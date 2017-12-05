import React, { Component } from 'react'
import { Link } from "react-router-dom";
import img from './summerHouse.jpg';
import locations from './location.json';
import ReactStars from 'react-stars';

const location = locations

class HousePage extends Component{

    constructor(){
        super();
        
        this.state ={
            location : location
        };
    }

    render(){
        return(
    <div className = "container"> 
    {this.state.location.map(item =>
        <div id = {item.id}>
            <img className = "img-responsive" src= {item.imgURL}alt="" width="800" height="600"/>   
                <ReactStars
                    count ={5}
                    value = {item.rating}
                    size = {25}
                    color2 = {'#ffd700'}/>
                        <div className = "description">
                            <span> {item.description}</span>
                        </div>
        </div>
    
    )}
    </div>
        )
    }
}

export default HousePage;