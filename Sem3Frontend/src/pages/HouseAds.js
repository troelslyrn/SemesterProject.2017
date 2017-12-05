import React, { Component } from 'react'
import { Link } from "react-router-dom";
import img from './summerHouse.jpg';
import locations from './location.json';
import ReactStars from 'react-stars';
import HousePage from './HousePage';


const ratingChange = (newRating) => {

}
const location = locations

class HouseAds extends Component{
    
    constructor(){
        super();
        
        this.state ={
            location : location
        };
    }


    render(){
        return(
<div className = "container" >  
    {this.state.location.map(item => 
        <div key = {item.id}>
            <div className = "col-sm-3">
                <img onClick={() => this.redirect(item.id)} className = "img-responsive" src={item.imgURL} alt="" width="460" height="345"/>        
                    <ReactStars
                    count = {5}
                    value = {item.rating}
                    size = {24}
                    color2 = {'#ffd700'} />
                        <div className = "adress">
                            <span> {item.city}, {item.street}</span>
                        </div>
           </div>
        </div>
    )}
</div>
        )
    }

    redirect (id){
        
        alert("redirected" + id);
        

    }

}

export default HouseAds;