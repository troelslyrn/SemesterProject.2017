import React, { Component } from 'react'
import { Link } from "react-router-dom";
//import {summerHouse} from "./images";
import img from './summerHouse.jpg'
//import Calendar from 'rc-calendar';

class HouseAds extends Component{
    myFunciton(x){
         return x + 20;
    }
    render(){
        return(
            
            <div className = "container" > 
           
           <div className = "row">
           <div className = "col-sm-6">
           <img className = "img-responsive" src={require('./summerHouse.jpg')} alt="summer house" width="460" height="345"/>        
           </div>
           <div className = "col-sm-6">
           <img className = "img-responsive" src={require('./summerHouse.jpg')} alt="summer house" width="460" height="345"/> 
           </div>
           </div>
           
           <div className = "row">
            <div className = "col-sm-6">
            <span><b>Adress</b></span>
            <p> zip<b> Street</b> </p>
            <p>Here we display the stars  &#9733;&#9733;&#9733;&#9733;&#9733;&#9733;</p>
   
            </div>
            <div className = "col-sm-6">
            <p> snother piece of text here</p>
            {/*<Calendar/>*/}
            </div>
           </div>
   <div>
   <span> {this.myFunciton(
       this.props.number
   )}</span>
   </div>
           </div>
        
        )
    }

}

export default HouseAds;