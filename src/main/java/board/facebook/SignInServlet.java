package board.facebook;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;

public class SignInServlet extends HttpServlet {
    private static final long serialVersionUID = -7453606094644144082L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = new FacebookFactory().getInstance();
        
        Properties prop = new Properties();
		prop.load(this.getClass().getClassLoader().getResourceAsStream("facebook.properties"));
		final String appId = prop.getProperty("appId");
		final String appSecret = prop.getProperty("appSecret");
    	facebook.setOAuthAppId(appId, appSecret);


        request.getSession().setAttribute("facebook", facebook);
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/facebookcallback");
        response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
    }
}
