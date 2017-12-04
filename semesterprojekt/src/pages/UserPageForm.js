import React, { Component}  from 'react';
import ReactDOM from 'react-dom';

class UserPageForm extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        house: {city: "",street:"", number: null, description: ""}

        
      };
      this.handleChange = this.handleChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }
  //constructor end
  
  //handlers start
    handleSubmit = (evt) =>{
       evt = document.getElementById("createLocationForm");
    window.alert(JSON.stringify(this.state.house));
    this.handleClear();
    }

    handleChange(event) {
    this.setState({value: event.target.value});
      }


      handleClear = () => { 
        this.refs.cityRef.value ="";
        this.refs.streetRef.value ="";
        this.refs.numberRef.value ="";
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
                <input ref = "cityRef" class="form-control" id="city" type="text" value={this.state.house.city}
                    placeholder="City" onChange={this.handleInput}/>
                <input ref = "streetRef" class="form-control" id="street" type="text" value={this.state.house.street}
                    placeholder="Street" onChange={this.handleInput}/>
                <input ref = "numberRef" class="form-control" id="number" type="number" value={this.state.house.number}
                    placeholder="Number" onChange={this.handleInput}/>
                <textarea ref = "descRef" style={{height: 100}} class="form-control" id="description" type="text" value={this.state.house.description}
                    placeholder="Description" onChange={this.handleInput}/>
                <button onClick= {this.handleSubmit} type="submit" class="btn btn-success">Submit</button>
                <button onClick= {this.handleClear} type="button" class="btn btn-default">Clear</button>
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