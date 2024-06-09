package app;

import java.util.ArrayList;

import helper.WebsiteElementBuilder;
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

public class PageIndex implements Handler {
    WebsiteElementBuilder elements = new WebsiteElementBuilder();

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Homepage</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";

        html = html + elements.getExtraCSS();

        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add the topelements
        // This uses a Java v15+ Text Block
        
        html = html + elements.getNavBar();

        // Add Div for page Content
        html = html + "<div class='content'>";

        // Add header content
        //Image Credits: https://stock.adobe.com/au/Library/urn:aaid:sc:AP:726decc2-5dcc-4f8c-9401-fc8719bcff2e?asset_id=118175173
        html = html + """
            <div id='header-grid' class='header-section'>
                <div class='header'>
                    <h1>The Road to a <br>
                    Greener Future <br>
                    Starts With You.</h1>
                    <div class='header-button'>
                        <a href='mission.html'>
                            <button class="button">Learn More</button>
                        </a>
                    </div>
                </div>
                <div>
                    <img src='./AdobeStock_LandingPageVeggies.jpeg' class='top-image' alt='Fresh Veggies'>
                </div>
            </div>
        """;

        // Add HTML for the damages section
        html = html + """
            <div class='damages-section'>
                <div class='damages-heading-grid'>
                    <h2>Let us take a look at the <br>damages...</h2>
                    <div class='damages-tooltip'>
                        <h3>High Impact Data</h3>
                        <p>There is where I tell you what data the table is showing you</p>
                        <h4>1966 - 2002</h4>
                    </div>
                </div>
                <div class='damages-tables-grid'>
                    <div class='damages-table'>
                        <table>
                            <tr>
                                <th>Country</th>
                                <th>Percentage</th>
                            </tr>
                            <tr>
                                <td><h3>Australia</h3></td>
                                <td><h4 target='red'>87%</h4></td>
                            </tr>
                            <tr>
                                <td><h3>America</h3></td>
                                <td><h4>95%</h4></td>
                            </tr>
                            <tr>
                                <td><h3>Italy</h3></td>
                                <td><h4>42%</h4></td>
                            </tr>
                            <tr>
                                <td><h3>Brazil</h3></td>
                                <td><h4>76%</h4></td>
                            </tr>
                        </table>
                    </div>

                    <div class='damages-table'>
                        <table>
                            <tr>
                                <th>Country</th>
                                <th>Percentage</th>
                            </tr>
                            <tr>
                                <td><h3>Australia</h3></td>
                                <td><h4>87%</h4></td>
                            </tr>
                            <tr>
                                <td><h3>America</h3></td>
                                <td><h4 target='red'>95%</h4></td>
                            </tr>
                            <tr>
                                <td><h3>Italy</h3></td>
                                <td><h4>42%</h4></td>
                            </tr>
                            <tr>
                                <td><h3>Brazil</h3></td>
                                <td><h4>76%</h4></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class='damages-button'>
                    <button class="button">Show More</button>
                </div>
            </div>
            """;

        // Add HTML for the businesses section
        html = html + """
            <div class='business-section'>
                <div class='business-heading-grid'>
                    <h2>What businesses are doing to <br>
                    help this social challenge</h2>
                </div>
                <div class='business-item-grid'>
                    <div class='business-item'>
                        <h3>Woolworths</h3>
                        <p>There is where I tell you what data the table is showing you</p>
                        <div class='business-button'>
                            <a href='mission.html'>
                                <button class="button">Learn More</button>
                            </a>
                        </div>
                    </div>
                    <div class='business-item'>
                        <h3>Woolworths</h3>
                        <p>There is where I tell you what data the table is showing you</p>
                        <div class='business-button'>
                            <a href='mission.html'>
                                <button class="button">Learn More</button>
                            </a>
                        </div>
                    </div>
                </div>

                <div class='business-item-grid'>
                    <div class='business-item'>
                        <h3>Woolworths</h3>
                        <p>There is where I tell you what data the table is showing you</p>
                        <div class='business-button'>
                            <a href='mission.html'>
                                <button class="button">Learn More</button>
                            </a>
                        </div>
                    </div>
                    <div class='business-item'>
                        <h3>Woolworths</h3>
                        <p>There is where I tell you what data the table is showing you</p>
                        <div class='business-button'>
                            <a href='mission.html'>
                                <button class="button">Learn More</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        """;

        // // Get the ArrayList of Strings of all countries
        // ArrayList<String> countryNames = getAllCountries();

        // // Add HTML for the country list
        // html = html + "<h1>All Countries in the food loss database</h1>" + "<ul>";

        // // Finally we can print out all of the countries
        // for (String name : countryNames) {
        //     html = html + "<li>" + name + "</li>";
        // }

        // // Finish the List HTML
        // html = html + "</ul>";

        // // Close Content div
        // html = html + "</div>";

        // Footer
        html = html + elements.getFooter();

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }


    /**
     * Get the names of the countries in the database.
     */
    public ArrayList<String> getAllCountries() {
        // Create the ArrayList of String objects to return
        ArrayList<String> countries = new ArrayList<String>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(JDBCConnection.DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM country";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                String countryName  = results.getString("countryName");

                // Add the country object to the array
                countries.add(countryName);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just print the error
            System.err.println(e.getMessage());
            //e.printStackTrace();
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
                //e.printStackTrace();
            }
        }

        // Finally we return all of the countries
        return countries;
    }
}
