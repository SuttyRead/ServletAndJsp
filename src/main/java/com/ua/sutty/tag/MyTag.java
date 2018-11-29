package com.ua.sutty.tag;

import com.ua.sutty.domain.Role;
import com.ua.sutty.domain.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class MyTag implements Tag {

    private PageContext pageContext = null;
    private Tag parent = null;
    private List<User> users = null;
    private List<Role> roles = null;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public PageContext getPageContext() {
        return pageContext;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    @Override
    public void setParent(Tag tag) {
        this.parent = tag;
    }

    @Override
    public Tag getParent() {
        return this.parent;
    }

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
                stringBuilder.append(ageCounting(user.getBirthday()));
                stringBuilder.append("</td>").append("<td>");
                stringBuilder.append(getRoleName(user.getRoleId()));
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

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    @Override
    public void release() {
        pageContext = null;
        parent = null;
    }

    private int ageCounting(Date birthday) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String birth = formatter.format(birthday);
        String currentYear = formatter.format(System.currentTimeMillis());
        return Integer.parseInt(currentYear) - Integer.parseInt(birth);
    }

    private String getRoleName(Long id) {
        for (Role role:roles){
            if (role.getId()==id){
                return role.getName();
            }
        }
        return null;
    }

}
