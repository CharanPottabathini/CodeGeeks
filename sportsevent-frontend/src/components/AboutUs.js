import React from "react";
import { withStyles } from "@material-ui/core/styles";

const styles = (theme) => ({
  root: {
    display: "flex",

  },
});


class AboutUs extends React.Component {
  state = {
   eventDetails: [],
   isShowCard:true,
   newEventDetails: [],
  };

  

  render() {
    return (

        <div class ="aboutus">

            <p className="aboutustext">
                <strong>“We are Code Geeks”</strong>
            </p>
            <br></br>
            <p className="aboutustext">
                <strong></strong>
            </p>
            <br></br>
            <p className="aboutustext">
                We as a team contributed hard enough to develop the Sports management
                system application. This application is an online platform where students
                can register and authenticate using the credentials. All the sports events
                that are going around in the university and the upcoming events that are
                going to be happened within a month are being displayed. The key theme of
                this application is to provide students about the updated information about
                the activities going around the university.
            </p>
            <br></br>
            <p className="aboutustext">
                Behind this successful application, we have collaborated a team and went
                through all phases of the software lifecycle and gained expertise on
                troubleshooting and maintain the application
            </p>
            <br></br>
            <p className="aboutustext">
                <strong>Meet the Developers:</strong>
            </p>
            <br></br>
            <p className="aboutustext">
                Anudeep: He has around 4+ years hands-on Java full stack and expertise on
                the IntelliJ and VS Code software’s.
            </p>
            <br></br>
            <p className="aboutustext">
                Charan: He holds an overall experience of 5+ years dealing with React and
                Angular frameworks and expertise in handling performance issues and
                applying optimization methods.
            </p>
            <br></br>
            <p className="aboutustext">
                Abhiram: He has around 3+ years of experience in core Java and advanced
                java applications and strong expertise in Spring boot and Hibernate
                concepts.
            </p>
            <br></br>
            <p className="aboutustext">
                Aditya: He has more than 3 years of experience in React framework. Strong
                hands-on expertise in writing MYSQL queries and designing the database.
            </p>
            <br></br>
            <p className="aboutustext">
                Raajitha: She has around 3+ experience in handling Java spring boot and
                hibernate applications. Expertise in designing Oracle and MYSQL databases.
            </p>
            <br></br>
            <p className="aboutustext">
                Chaitanya: He holds an overall experience of 5+ years dealing with React
                and Angular frameworks. Strong backend expertise in designing MYSQL
                database and writing automated test scripts.
            </p>
            <br></br>
            <p className="aboutustext">
                Deepthi: She has more than 3 years of experience in Angular framework.
                Strong hands-on expertise in writing Oracle queries and designing the
                database.
            </p>
            <br></br>
            <p className="aboutustext">
                Manisha: She has around 3+ years of experience in core Java and advanced
                java applications and strong expertise in Spring boot and Hibernate
                concepts.
            </p>
            <br></br>
            <p className="aboutustext">
                Shri Lakshmi: She has around 2+ years of experience in React and Devops
                Expertise in designing Oracle and MYSQL databases.
            </p>
            <br></br>
            <p className="aboutustext">
                Meghana: She has around 2 years of experience in MVC architecture and advanced
                java applications and Design Patterns
            </p>
        </div>

    );
  }
}

export default withStyles(styles)(AboutUs);
