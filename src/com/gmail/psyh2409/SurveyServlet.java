package com.gmail.psyh2409;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SurveyServlet", urlPatterns = {"/statistics", "/"})
public class SurveyServlet extends HttpServlet {
    Map<String, Map<String, Integer>> statAnswersMap = new LinkedHashMap<>();
    List<String> statements = new Questionnaire().getAssertions();
    String template = "<html><head><title>Survey</title></head><body><h1>%s</h1>" +
            "<button onclick=\"location.href = '/';\" id=\"myButton\" class=\"float-left submit-button\" >" +
            "Go home!</button></body></html>";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");
        if (statAnswersMap.isEmpty()) {
            for (int i = 0; i < statements.size(); i++) {
                Map<String, Integer> innerMap = new LinkedHashMap<>();
                innerMap.put("yes", 0);
                innerMap.put("no", 0);
                statAnswersMap.put(statements.get(i), innerMap);
            }
        }
        for (int i = 0; i < statAnswersMap.size(); i++) {
            String answer = req.getParameter("answer".concat(String.valueOf(i)));
            Map<String, Integer> map = statAnswersMap.get(statements.get(i));
            int num = (int) map.get(answer);
            num++;
            map.put(answer, num);
        }
        StringBuilder answer = new StringBuilder("<p>Statistics:<br>");
        for (Map.Entry<String, Map<String, Integer>> sam: statAnswersMap.entrySet()) {
            answer.append(sam.getKey()).append("<br>");
            for (Map.Entry<String, Integer> map: sam.getValue().entrySet()) {
                answer.append(map.getKey()).append(" - ").append(map.getValue()).append("<br>");
            }
        }
        answer.append("</p>");
        resp.getWriter().println(String.format(template, answer));
    }

}
