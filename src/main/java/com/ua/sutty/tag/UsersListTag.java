package com.ua.sutty.tag;

import com.ua.sutty.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersListTag extends BodyTagSupport {

    private static Logger logger = LoggerFactory.getLogger(UsersListTag.class);
    private List<User> listOfUsers = new ArrayList<>();

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    private List<User> users;

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        if (users != null) {
            StringBuilder stringBuilder = new StringBuilder("<table class=\"table table-bordered\">");
            stringBuilder.append("<tr><th>Login</th><th>First Name</th><th>Last Name</th><th>Age</th><th>Role</th>" +
                    "<th>Action</th><th>Action</th></tr>");
            for (User user : users) {
                stringBuilder.append("<tr>").append("<td>");
                stringBuilder.append(user.getLogin());
                stringBuilder.append("</td>").append("<td>");
                stringBuilder.append(user.getFirstName());
                stringBuilder.append("</td>").append("<td>");
                stringBuilder.append(user.getLastName());
                stringBuilder.append("</td>").append("<td>");
                stringBuilder.append(user.getBirthday());
                stringBuilder.append("</td>").append("<td>");
                stringBuilder.append(user.getRoleId());
                stringBuilder.append("</td>").append("<td>");
                stringBuilder.append("<a id=\"remove\" onclick=\"post(" + user.getId() + ")\">delete</a>");
                stringBuilder.append("</td>").append("<td>");
                stringBuilder.append("<a id=\"edt\" onclick=\"get(" + user.getId() + ")\">edit</a>");
                stringBuilder.append("</td>").append("</tr>");
            }
            stringBuilder.append("</table>");
            try {
                out.print(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return SKIP_BODY;
    }

    private int getAge(int birthday, int thisyear) {
        return thisyear - birthday;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}