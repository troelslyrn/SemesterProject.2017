import React, { Component } from 'react'

class smallLocation extends Component {

constructor{
  super(props);
}

  const location = {
      imgULR : 'https://static.pexels.com/photos/164516/pexels-photo-164516.jpeg',
      description : 'Something somthing ...',
      city : 'Copenhagen',
      street : 'Istedgade'
  }

  render(){
    return(

    //<div className="location-form">

    //<div className="img-location">
      //<img src={props.imgULR} alt="wtf"> </img>
    //</div>

    //<div className="location-rating">

    //</div>

    //<div className="location-description">
    //<span>{props.descriptio}</span>

    //<div className="location-address">
    //<span> {prips.City}, {props.Street} </spin>
    //</div>
    <Comment/>
)}
}

function Comment(props) {
  return (
    <div className="Comment">
      <div className="UserInfo">
        <img className="Avatar"
             src={props.author.avatarUrl}
             alt={props.author.name} />
        <div className="UserInfo-name">
          {props.author.name}
        </div>
      </div>
      <div className="Comment-text">
        {props.text}
      </div>
      <div className="Comment-date">
        {formatDate(props.date)}
      </div>
    </div>
  );
}

const comment = {
  date: new Date(),
  text: 'I hope you enjoy learning React!',
  author: {
    name: 'Hello Kitty',
    avatarUrl: 'http://placekitten.com/g/64/64'
  }
};
