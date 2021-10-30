import React from "react";
import { withStyles } from "@material-ui/core/styles";



const styles = (theme) => ({
    root: {
        display: "flex",

    },

});


class CreateEvent extends React.Component {
    state = {
        eventDetails: [],
        isShowCard:true,
        newEventDetails: [],
    };



    render() {
        return (
            <div class="myDiv">
                <img src="http://localhost:3000/unt.jpg" />

            </div>
        );
    }
}

export default withStyles(styles)(CreateEvent);
