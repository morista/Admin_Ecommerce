package mor.form.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Restriction implements Filter {
	
	public static final String ACCES_CONNEXION		= "/connexion"; 
	public static final String SESSION_USER			= "sessionUtilisateur";
	
	@Override
	public void destroy() {
		

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		/**
		 * Cast de req et res
		 */
		HttpServletRequest request  = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		/**
		 * Non filtrage du dossier inc
		 */
		String chemain	= request.getRequestURI().substring(request.getContextPath().length());
		if(chemain.startsWith("/inc")){
			chain.doFilter(request, response);
			return ;
		}
		/**
		 * Réccupération de la session
		 */
		HttpSession session 	= request.getSession();
		
		/**
		 * Vérification si User est connecté
		 */
		if(session.getAttribute(SESSION_USER) == null){
			request.getRequestDispatcher(ACCES_CONNEXION).forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
