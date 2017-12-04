import React from "react"
import {Route, Switch } from "react-router-dom"
import Login from "./Login";
import Logout from "./Logout";
import About from "./About";
import UserPage from "./UserPage";
import AdminPage from "./AdminPage";
import TopMenu from "./TopMenu";
import HouseAds from "./HouseAds";

import images from"./images";

import register from './RegForm';
import HousePage from "./HousePage";



    
function App(props) {

  return (
    <div>
      <TopMenu />
      <Switch>
        <Route path="/login" component={Login} />
        <Route path="/logout" component={Logout} />
        <Route path="/about" component={About} />
        <Route path="/user" component={UserPage} />
        <Route path="/admin" component={AdminPage} />
        <Route path="/images" component={images}/>
        <Route path="/register" component={register}/>
        <Route path = "/house" component = {HousePage}/>

        //Shall be the last line, or else...
        <Route path="/" render={(props) => (<HouseAds number={23} />)} /> />
      </Switch>
    </div> 
  )
}
export default App;