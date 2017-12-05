import React, { Component } from 'react'
import userData from "../facades/userFacade";
import UserPageForm from "./UserPageForm";
import auth from "../authorization/auth"
import { Link } from "react-router-dom";
class UserPage extends Component {

  
    constructor(){
      super();
      this.state = {loggedIn: auth.isloggedIn,data: "", err:""}
      
    }

    // clear(){
    //   var labels = document.getElementsByTagName("label");
    //   labels.value = ("");
    // }
 
    Greeting(props) {
      const isLoggedIn = props.isLoggedIn;
      if (isLoggedIn) {
        return <UserPageForm />;
      }
     
    }
    componentWillMount() {
      /*
      This will fetch data each time you navigate to this route
      If only required once, add "logic" to determine when data should be "refetched"
      */
      userData.getData((e,data)=>{
        if(e){
          return this.setState({err:e.err})
        }
        this.setState({err:"",data});
      });
    }
    render() { console.log("adsfa", this.state.loggedIn)
      return (
  <div className = "container">
          <h2>Users</h2>
          <p>This message is fetched from the server if you are properly logged in</p>
          <li><Link to="/images">Images</Link></li>
          <div className="msgFromServer">
          {this.state.data}  
          </div>
          { this.state.err && ( 
            <div className="alert alert-danger errmsg-left" role="alert"> 
              {this.state.err}
            </div>
          )}
          
    {this.state.loggedIn &&
  <UserPageForm /> 

    }
   
 

  </div>
      )
    }

  }

export default UserPage;