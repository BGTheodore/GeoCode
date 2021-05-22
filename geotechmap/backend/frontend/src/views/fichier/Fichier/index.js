// import React from 'react';
// // import logo from './logo.svg';  className="Fichier"
// // import './Fichier.css';
// function Fichier() {
//   return (
//   <div>
//   Hello World !
// </div>
   
//   )
// } export default Fichier;

import axios from 'axios';
import React,{Component} from 'react';

class Fichier extends Component {

	state = {

	// Initially, no file is selected
	selectedFile: null
	};
	
	// On file select (from the pop up)
	onFileChange = event => {
	
	// Update the state
	this.setState({ selectedFile: event.target.files[0] });
	
	};
	
	// On file upload (click the upload button)
	onFileUpload = () => {
	
	// Create an object of formData
	const formData = new FormData();
	
	// Update the formData object
	formData.append(
		"myFile",
		this.state.selectedFile,
		this.state.selectedFile.name
	);
	
	// Details of the uploaded file
	console.log(this.state.selectedFile);
	
	// Request made to the backend api
	// Send formData object
	// axios.post("api/uploadfile", formData);
	};
	
	// File content to be displayed after
	// file upload is complete
	fileData = () => {
	
	if (this.state.selectedFile) {
		
		return (
		<div>
			<h2>Informations sur le fichier:</h2>
			
<p>Nom du fichier: {this.state.selectedFile.name}</p>

			
<p>Type du fichier: {this.state.selectedFile.type}</p>

			
<p>
			Dernière modification:{" "}
			{this.state.selectedFile.lastModifiedDate.toDateString()}
			</p>

		</div>
		);
	} else {
		return (
		<div>
			<br />
			<h4>Prière de choisir un fichier !!</h4>
		</div>
		);
	}
	};
	
	render() {
	
	return (
		<div>
			<h3>
			Veuillez ajouter un fichier!
			</h3>
			<div>
				<input type="file" onChange={this.onFileChange} />
				<button onClick={this.onFileUpload}>
				Enregistrer
				</button>
			</div>
		 {this.fileData()}
		</div>
	);
	}
}

export default Fichier;
