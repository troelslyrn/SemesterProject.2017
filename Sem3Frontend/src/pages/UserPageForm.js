import React, { Component}  from 'react';
import ReactDOM from 'react-dom';

class UserPageForm extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        house: { description: "",housenr: null, img : "", street:"", idrating:"", username:"", zip:null}

        
      };
      this.handleChange = this.handleChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }
  //constructor end
  
  //handlers start
    handleSubmit = (evt) =>{

       fetch('http://localhost:8084/seedMaven2/api/LocationRest/AddLocation', {
         method : 'POST',
         
         headers : {'Accept': 'application/json',"Content-Type" : "application/json"},
         body: JSON.stringify({ 
          "street" :  this.refs.streetRef.value,
          "description" : this.refs.descRef.value,
            "housenr" : this.refs.housenr.value,
           "zip" :  this.refs.zipRef.value
         })
       })


    this.handleClear();
    }

    handleChange(event) {
    this.setState({value: event.target.value});
      }


      handleClear = () => { 
        this.refs.housenr.value ="";
        this.refs.streetRef.value ="";
        this.refs.zipRef.value ="";
        this.refs.descRef.value ="";
        
      }
  
    handleInput = (event) => {
      const target = event.target;
      const prop = target.id;
      var value = target.value;
      var house = this.state.house;
      house[prop] = value;
      this.setState({
        house : house
      });
    }
  //handlers end
  
  //form start
    render() {
      return (
<div className = "row" >
    <div className = "col-sm-4">
        <form  id = "createLocationForm" >
            <div className = "form-group">
                <input ref = "housenr" className="form-control" id="housenr" type="number" 
                     placeholder="House number"/>
                <input ref = "streetRef" className="form-control" id="street" type="text"
                    placeholder="Street"/>
                <input ref = "zipRef" className="form-control" id="zip" type="number"
                    placeholder="Zipcode"/>
                <textarea ref = "descRef" style={{height: 100}} className="form-control" id="description" 
                type="text"
                    placeholder="Description"/>
                <button onClick= {this.handleSubmit} type="submit" className="btn btn-success">Submit</button>
                <button onClick= {this.handleClear} type="button" className="btn btn-default">Clear</button>
            </div>
        </form>

          <p>{JSON.stringify(this.state.house)}</p>
    </div>
</div>
      );
    }
    //form end
  }
  


  export default UserPageForm;