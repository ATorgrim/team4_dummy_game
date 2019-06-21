package Web;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@WebServlet("/SearchListServlet")

public class SearchListServlet extends HttpServlet{
	  public static String getCookieValue(Cookie[] cookies,String cookieName){
		  for(int i=0; i<cookies.length; i++) {
			  Cookie cookie = cookies[i];
			  if (cookieName.equals(cookie.getName()))
				  return(cookie.getValue());
		  }
		  return(cookieName);
	  	}
}

// Check out the inventory2.jsp for this to make sense
// this was meant to provide a means of displaying a matching list of cookies(items) through user input
// through the search bar
