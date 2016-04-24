package board.facebook;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer callbackURL = request.getRequestURL();
		int index = callbackURL.lastIndexOf("/");
		callbackURL.replace(index, callbackURL.length(), "").append("/callback");

		Properties prop = new Properties();
		prop.load(this.getClass().getClassLoader().getResourceAsStream("facebook.properties"));
		final String appId = prop.getProperty("appId");

		final String url =
			"https://www.facebook.com/dialog/oauth?client_id="
				+ appId
				+ "&redirect_uri="
				+ callbackURL
				+ "&scope=publish_actions";
		response.sendRedirect(url);
	}
}
