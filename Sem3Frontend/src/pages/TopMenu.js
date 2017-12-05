import React, { Component } from 'react'
import { Link } from "react-router-dom";
import auth from '../authorization/auth';
import TiHomeOutline from 'react-icons/lib/ti/home-outline';


class TopMenu extends Component {

  constructor(props){
    super(props);
    this.state = {loggedIn: auth.isloggedIn, userName:auth.userName,isUser:auth.isUser,isAdmin:auth.isAdmin}
  }

  loginStatus = (status,userName,isUser,isAdmin) =>{
    this.setState({loggedIn: status, userName,isUser,isAdmin});
  }

  componentDidMount(){
     auth.setLoginObserver(this.loginStatus);
  }

  render() {

    const logInStatus = this.state.loggedIn ? "Logged in as: " + this.state.userName : "";
    //console.log("RENDERING - REMOVE ME",JSON.stringify(this.state));
    return (
      <div>
        <nav className="navbar navbar-default" >
        
          <div className="container-fluid">
            <ul className="nav navbar-nav">
              <li> <Link to = "/"> <TiHomeOutline/></Link> </li>
              <li><Link to="/about">About</Link></li>
              {(this.state.isUser) &&
              <li><Link to="/user">Page for Users </Link></li>
              }
              {(this.state.isAdmin) && 
              <li><Link to="/admin">Page for Admins</Link></li>
              }
             
            </ul>
            <ul className="nav navbar-nav navbar-right">
            {!this.state.loggedIn &&
              <li><Link to="/register" ><span className = "	glyphicon glyphicon-registration-mark "></span>Sign up</Link></li>}
              <li className="navbar-text" style={{ color: "steelBlue" }}>{logInStatus}</li>
              <li>
                {this.state.loggedIn ?
                  (
                    <Link to="/logout"><span className="glyphicon glyphicon-log-in"></span> Logout</Link>
                  ) :
                  (
                    <Link to="/login">
                      <span className="glyphicon glyphicon-log-out"></span> Login </Link>
                  )}
              </li>
            </ul>
          </div>
        </nav>
        
      </div>
    )
  }
}


  export default TopMenu;
