package com.ua.sutty.tag;

import com.ua.sutty.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class TablePrinterTag implements Tag {
    private static final Logger logger = LoggerFactory
            .getLogger(TablePrinterTag.class);
    private PageContext context;
    private Tag parent;

    private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void setPageContext(PageContext pc) {
        context = pc;
    }

    @Override
    public void setParent(Tag t) {
        parent = t;
    }

    @Override
    public Tag getParent() {
        return parent;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    @Override
    public void release() {

    }

    public int doStartTag() throws JspException {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        JspWriter out = context.getOut();

        sb.append("<table class=\"table table-hover table-bordered\">\n")
                .append("<thead>\n").append("<tr>\n").append("<th>").append("#").append("</th>").append("<th>Login</th>\n")
                .append("<th>First Name</th>\n").append("<th>Last Name</th>\n")
                .append("<th>Age</th>\n").append("<th>Role</th>\n")
                .append("<th>Actions</th>\n").append("</tr>\n")
                .append("</thead>\n").append("<tbody>\n");

        if (userList != null) {
            for (User user : userList) {

//                Date birthday = user.getBirthday();
//                int a = birthday.getYear();
//                int year = LocalDate.now().getYear();
//                long age = ChronoUnit.YEARS.between(user.getBirthday().toLocalDate(), LocalDate.now());
//                long age = LocalDate.now().getYear() - user.getBirthday().getYear();
                sb.append("<tr>").append("<th>").append(count++).append("</th>").append("\n<td>").append(user.getLogin())
                        .append("</td>\n<td>").append(user.getFirstName())
                        .append("</td>\n<td>").append(user.getLastName())
                        .append("</td>\n<td>").append(ChronoUnit.YEARS.between(user.getBirthday().toLocalDate(), LocalDate.now())).append("</td>\n<td>")
                        .append(user.getRoleId() == 1 ? "Admin" : "User")

                        .append("</td>\n<td>")
                        .append("<form action=\"/edit\"  method=\"get\">\n")
                        .append("<input type=\"hidden\" name=\"userId\" value=")
                        .append(user.getId()).append(">\n")
//                        .append("<input type=\"hidden\" name=\"action\" >\n")
                        .append("<button type=\"submit\" class=\"btn btn-info ")
                        .append("\">Edit</button>\n")
                        .append("</form>")
                        .append("<form action=\"/delete\" method=\"post\">")

//                        .append("<a data-toggle=\"modal\" data-id=\"")
                        .append("<input type=\"hidden\" name=\"userIdForDelete\" value=")
                        .append(user.getId()).append(">\n")
//                        .append("class=\"btn btn-outline-danger\" href=\"#openDeleteDialog\">Delete</a>")
                        .append("<button type=\"submit\" class=\"btn btn-info ")
                        .append("\">Delete</button>\n")
                        .append("</form>\n")
                        .append("</td>\n").append("</tr>\n");
            }
            sb.append("</tbody>\n").append("</table>");
        }
        try {
            out.print(sb.toString());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        return SKIP_BODY;
    }
}