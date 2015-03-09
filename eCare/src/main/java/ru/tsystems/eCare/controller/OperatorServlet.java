package ru.tsystems.eCare.controller;

import org.apache.log4j.Logger;
import ru.tsystems.eCare.entity.Contract;
import ru.tsystems.eCare.entity.Option;
import ru.tsystems.eCare.entity.Plan;
import ru.tsystems.eCare.entity.User;
import ru.tsystems.eCare.service.implementation.OperatorServiceImpl;
import ru.tsystems.eCare.service.interfaces.OperatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Implements Front Controller pattern.
 * Created by sevasan on 3/8/2015.
 */
@WebServlet(name="OperatorServlet", urlPatterns = {"/secure/operator/operator"})
public class OperatorServlet extends HttpServlet {
    private final static Logger logger = Logger.getLogger(OperatorService.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * This method is invoked from both doPost and doGet methods. Processes all requests.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String resultPage;

        try {
            resultPage = getResultPage(request, response);
        } catch(Exception e) {
            Logger.getLogger(this.getClass()).error("Error processing request: ", e);
            resultPage = "/error.jsp";
        }
        //request.getRequestDispatcher(resultPage).forward(request, response);
        response.sendRedirect(resultPage);
    }

    /**
     * Analyzes request and retrieves result page to forwrad to.
     * @param request servlet request
     * @return resultPage to redirect
     */
    protected String getResultPage(HttpServletRequest request, HttpServletResponse response) {
        OperatorService operatorService = new OperatorServiceImpl();
        HttpSession session = request.getSession();
        String query = request.getParameter("q");
        String result = null;

        //OH GOD FIX THAT MESS PLZ MAH EYES
        if (query.equals("ContractList")) {
            List<Contract> contracts = operatorService.findAllContracts();
            session.setAttribute("ContractList", contracts);
            result = "/secure/operator/ContractList.jsp";
        } else if (query.equals("PlanList")) {
            List<Plan> plans = operatorService.findAllPlans();
            session.setAttribute("PlanList", plans);
            result="/secure/operator/PlanList.jsp";
        } else if (query.equals("OptionList")) {
            List<Option> options = operatorService.findAllOptions();
            session.setAttribute("OptionList", options);
            result = "/secure/operator/OptionList.jsp";
        } else if (query.equals("ClientList")) {
            List<User> users = operatorService.findAllUsers();
            session.setAttribute("ClientList", users);
            result = "/secure/operator/ClientList.jsp";
        } else if (query.equals("AddOption")) {
            Option option = new Option();

            option.setOptionTitle(request.getParameter("title"));
            option.setOptionPrice(Integer.parseInt(request.getParameter("price")));
            option.setOptionActivationPrice(Integer.parseInt(request.getParameter("activationPrice")));

            operatorService.createOption(option);

            List<Option> options = operatorService.findAllOptions();
            session.setAttribute("OptionList", options);
            result = "/secure/operator/OptionList.jsp";
        } else if (query.equals("AddClient")) {
            User user = new User();

            user.setUserName(request.getParameter("name"));
            user.setUserLastName(request.getParameter("lastname"));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setUserBirthday(format.parse(request.getParameter("birthdate")));
            } catch (ParseException e) {
                logger.error("Parser exception with birthdate: ", e);
            }
            user.setUserIDCard(request.getParameter("idcard"));
            user.setUserAddress(request.getParameter("address"));
            user.setUserEmail(request.getParameter("email"));
            user.setUserPassword(request.getParameter("password"));

            operatorService.createClient(user);

            List<User> users = operatorService.findAllUsers();
            session.setAttribute("ClientList", users);
            result = "/secure/operator/ClientList.jsp";
        } else if (query.equals("DeleteClient")) {
            long id = Long.parseLong(request.getParameter("clientID"));

            operatorService.removeClient(id);

            List<User> users = operatorService.findAllUsers();
            session.setAttribute("ClientList", users);
            result = "/secure/operator/ClientList.jsp";
        }
        return result;
    }
}
