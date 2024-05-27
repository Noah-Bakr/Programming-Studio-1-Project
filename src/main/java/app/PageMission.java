package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2023. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class PageMission implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/mission.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Our Mission</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        html = html + """
            <div class='topnav'>
                <a href='/'>Homepage</a>
                <a href='mission.html'>Our Mission</a>
                <a href='page2A.html'>Sub Task 2.A</a>
                <a href='page2B.html'>Sub Task 2.B</a>
                <a href='page3A.html'>Sub Task 3.A</a>
                <a href='page3B.html'>Sub Task 3.B</a>
            </div>
        """;

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>Our Mission</h1>
            </div>
        """;

        // Add Div for page Content
        html = html + "<div class='content'>";

        // Add HTML for the page content
        html = html + """
            <h1>How the website addresses the social challenge</h1>
            """;

        html = html + "<p>Sample text</p>";

        html = html + "<h1>Usage and primary functions</h1>";

        html = html + "<p>William Bore</p>";

        // This example uses JDBC to lookup the countries
        JDBCConnection jdbc = new JDBCConnection();

        // Next we will ask this *class* for the Countries
        ArrayList<Country> countries = jdbc.getAllCountries();

        ArrayList<Persona> personas = jdbc.getAllPersonas();

        // Add HTML for the countries list
        // html = html + "<h1>All Countries in the foodloss database (using JDBC Connection)</h1>" + "<ul>";

        // Finally we can print out all of the Countries
        // for (Country country : countries) {
        //     html = html + "<li>" + country.getM49Code()
        //                 + " - " + country.getName() + "</li>";
        // }

            html = html + "<h1>Personas</h1>";

            //TODO Fix quotation marks breaking
        for(Persona persona : personas)
        {
            // html = html + "<personaIntro>";
            html = html + "<h2>"+persona.getName()+"</h2>";
            html = html + "<p>"+ persona.getAttributes() + " " + persona.getBackground() +"</p>";
            html = html + "<img src ='./" + persona.getImage() + "'class = 'persona_thumbnail'>";
            // html = html + "</personaIntro>";
            html = html + "<h3>Needs</h3>";
            html = html + "<p>" + persona.getNeeds() + "</p>";
            html = html + "<h3>Goals</h3>";
            html = html + "<p>" + persona.getGoals() + "</p>";
            html = html + "<h3>Skills and Experience</h3>";
            html = html + "<p>" + persona.getSkills() + "</p>";
        }

        // Finish the List HTML
        html = html + "</ul>";


        // Close Content div
        html = html + "</div>";

        // Footer
        html = html + """
            <div class='footer'>
                <p>COSC2803 - Studio Project Starter Code (Apr24)</p>
            </div>
        """;

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
