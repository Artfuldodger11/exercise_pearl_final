package mvc;

import javax.servlet.http.HttpServletRequest;

public interface MVCController {

    MVCModel processRequest(HttpServletRequest request);

}
