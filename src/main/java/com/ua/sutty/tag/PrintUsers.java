package com.ua.sutty.tag;

import com.ua.sutty.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

public class PrintUsers extends TagSupport {

    private List<User> users;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void setUsers(List users) {
        this.users = users;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();

        try {
            out.println("<table class=\"table-primary\" border='1' align='center'>");
            out.print("<tr>" +
                    "<td>Login</td>" +
                    "<td>First name</td>" +
                    "<td>Last name</td>" +
                    "<td>Age</td>" +
                    "<td>Role</td>" +
                    "<td>Actions</td>" +
                    "</tr>");
            for (User user : users) {
                out.print("<tr>");
                out.print("<th hidden>" +
                        user.getId() + "</th>");
                out.print("<th>" +
                        user.getLogin() + "</th>");
                out.print("<th hidden>" +
                        user.getPassword() + "</th>");
                out.print("<th hidden>" +
                        user.getEmail() + "</th>");
                out.print("<th>" +
                        user.getFirstName() + "</th>");
                out.print("<th>" +
                        user.getLastName() + "</th>");
                out.print("<th>" +
                        calculateAge(user.getBirthday()) + "</th>");
                out.print("<th>" +
                        user.getRoleId() + "</th>");
                out.print("<td><a href=\"/editUser?id=" + user.getId() + "\">Edit    </a>");
                out.print("<a href=\"/deleteUser?id=" + user.getId() + "\" " +
                        "onclick=\"return confirm('Are you sure?')\">Delete   </a></td>");
                out.print("</tr>");
            }
            out.print("</table>");

        } catch (IOException e) {
            logger.error("Exception in doStartTag()", e);
            throw new RuntimeException(e);
        }
        return SKIP_BODY;
    }

    private int calculateAge(Date date) {
        LocalDate birthday = date.toLocalDate();
        int age = Period.between(birthday, LocalDate.now(ZoneId.of("America/Montreal"))).getYears();
        if (age < 0) {
            age = 0;
        }
        return age;
    }
}
