    package com.example.servletsagenda;

    import javax.servlet.ServletConfig;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.IOException;
    import java.io.PrintWriter;

    @WebServlet("/contador")
    public class Contador extends HttpServlet {

        public void init(ServletConfig config) throws ServletException {
            super.init(config);
            log("Iniciando a servlet");
        }
        public void destroy() {
            super.destroy();
            System.out.println("Destruindo a servlet");
        }
        private int contador = 0; //variavel de instância
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            contador++; // a cada requisição a mesma variável é incrementada

            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("Contador agora é: " + contador);
            out.println("</body>");
            out.println("</html>");
        }
    }
