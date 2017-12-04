import React from 'react';
import ImageUploader from 'react-images-upload';
 
export default class Images extends React.Component {
  constructor(props) {
    super(props);
     this.state = { pictures: [] };
     this.uploadFile = this.uploadFile.bind(this);
     this.onDrop = this.onDrop.bind(this);
}

uploadFile(pictures) {
  let file = pictures.target.files[0];
  console.log(file);
  
  if (file) {
    let data = new FormData();
    data.append('file', file);
    // axios.post('/files', data)...
  }
}
onDrop(picture) {
this.setState({
    pictures: this.state.pictures.concat(picture),
});
}

//   componentDidMount(){
//   fetch('http://localhost:8084/SeedPush/')
 // .then(adress =>{
   // return adress.json();
 // }).then(data =>{
   // let imageurl = data.adress.map((pic) =>{
     // return(
       // <div key={pic.adress}>
         // <img src={pic.imageurl}/>
       // </div>
     // )
   // })
    //this.setState({imageurl:imageurl});
   // console.log("state", this.state.imageurl);
 // })
//}

render() {
    return (
        <div>
        <div className="container2">
        <form action="http://localhost:8084/seedMaven2/" enctype="multipart/form-data" method="post">
        <ImageUploader
            withIcon={true}
            buttonText='Choose images'
            onChange= {this.onDrop}
           // onChange={this.uploadFile}
            imgExtension={['.JPG', '.gif', '.png', '.gif']}
            maxFileSize={5242880}
        />
        <button id="btn">Upload</button>
      </form>
      </div>
      </div>
    );
}
}