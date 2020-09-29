package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 815000
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title;
        String contents;  
        final String INSERT = "insert";
        final String EDIT = "edit";
        final String DELETE = "delete";
        
        // to read files
        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {
            title = br.readLine();
            contents = br.readLine();
            br.close();
        }
        
        String param = request.getParameter("type");
        if (param == null) {
            param = "";
        }

        Note note = new Note(title, contents); 
        
        switch (param) {
            case INSERT:
                delete();
                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
                break;
            case EDIT:
                request.setAttribute("note", note);
                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
                break;
            case DELETE:
                delete();
                getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
                break; 
            default:
                request.setAttribute("note", note);
                getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
                break;
        }            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        
        if (title == null || title.equals("") || contents == null || contents.equals("")) {
            Note note = new Note(title, contents);
            request.setAttribute("note", note);
            request.setAttribute("invalid", true);
            
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            
            return;
        }
        
        // to write to a file
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)))) {
            pw.println(title);
            pw.print(contents);
            pw.close();
        }
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
    
    private void delete() throws IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
         // to write to a file
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)))) {
            pw.println("");
            pw.close();
        }
        
    }
}
