import React ,{useState, useEffect, useRef} from 'react'
import {Formik, Form} from 'formik';
import { TextField } from '../commun/TextField';
import * as Yup from 'yup';
import {
  CCard,
  CCardBody,
  CCardFooter,
  CCardHeader,
  CCol,
  CFormGroup,
  CFormText,
  CRow,
  CAlert,
  CLabel,CInputFile
} from '@coreui/react'

const BasicForms = ({match}) => {

  useEffect(() => {
    //__START fetch all test types for the select field
      fetch(`${process.env.REACT_APP_API_URL}/api/type_essais/`)
        .then((response) => response.json())
        .then((json) => setAllTestTypes(json))
    //__END fetch all test types for the select field

    //__START fetch all test types for the select field
      fetch(`${process.env.REACT_APP_API_URL}/api/institutions/`)
      .then((response) => response.json())
      .then((json) => setAllInstitutions(json))
    //__END fetch all test types for the select field

   if( match.params.id ){
    fetch(`${process.env.REACT_APP_API_URL}/api/essais/`+match.params.id)
      .then((response) => response.json())
      .then((json) => setDataForEdit(json))   
   }
  }, []);

  const initVal ={
    typeEssai:'',
    institution:'',
    latitude:'',
    longitude:'',
    altitude:'',
    commentaire:'',
    motsCles:'',
    pdf:'',

  }
  const [myFile, setMyFile] = useState({file:null});//for the file
  const onFileChange = event => {
    // Update the state
    setMyFile({file: event.target.files[0]}); 
    };
const init = {
  typeEssai: {
    id:null
},
institution: {
    id:null
},
position: {
    id:null
},
fichier: {
    id:null
},
motsCles: '',
pdf:''
}
  const [dataForAPI = init, setDataForAPI, refDataForAPI] = useState();
  const dataForAPIref = useRef(dataForAPI);
  useEffect(
    () => { dataForAPIref.current = dataForAPI },
    [dataForAPI]
  )

  const imgRef = useRef(null);

  const [dataForEdit, setDataForEdit] = useState(null);
  const [allTestTypes, setAllTestTypes] = useState([]);
  const [allInstitutions, setAllInstitutions] = useState([]);
  const [alert, setAlert] = React.useState({ 
    isActive: false, status: '', message: '',})

  const validate = Yup.object({
    typeEssai: Yup.string()
      .max(45,"Maximum 45 caractères")
      .required("Champs obligatoire"),
    institution: Yup.string()
      .max(45,"Maximum 45 caractères")
      .required("Champs obligatoire"),
    latitude: Yup.string()
      .max(255,"Maximum 255 caractères")
      .required("Champs obligatoire"),
    longitude: Yup.string()
      .max(255,"Maximum 255 caractères")
      .required("Champs obligatoire"),
    altitude: Yup.string()
      .max(255,"Maximum 255 caractères")
      .required("Champs obligatoire"),
    commentaire: Yup.string()
      .max(255,"Maximum 255 caractères"),
    motsCles: Yup.string()
    .max(255,"Maximum 255 caractères"),
    // fichier: Yup.string()
    //   .max(255,"Maximum 255 caractères")
    //   .required("Champs obligatoire"),
  })
  

//  const toBase64 = file => new Promise((resolve, reject) => {
//   const reader = new FileReader();
//   reader.readAsDataURL(file);
//   reader.onload = () => resolve(reader.result);
//   reader.onerror = error => reject(error);
// });

const toBase64 = (file,callback) => {
  const reader = new FileReader();
  // reader.addEventListener('load',()=>callback(reader.result.substr(reader.result.indexOf(',') + 1)));
  reader.readAsDataURL(file);
// var base64result = reader.result.substr(reader.result.indexOf(',') + 1);
  reader.onloadend = () => {
    setDataForAPI({...dataForAPI, pdf:reader.result.substr(reader.result.indexOf(',') + 1)})
  }
}

const getBase64 = (file, callback) => {
  let reader = new FileReader();
  reader.readAsDataURL(file);
  reader.onload = () => {
    callback(reader.result);
  };
  reader.onerror = (error) => {
    console.log("Error: ", error);
  };
};

const handleChange = (event) => {
  const file = event.currentTarget.files[0];
  setMyFile({file: event.target.files[0]});//for just getting the name outside of the function
  getBase64(file, (result) => {
    setDataForAPI({...dataForAPI, pdf:result.substr(result.indexOf(',') + 1)})
 
  });
};

  return (
    <Formik
      initialValues = {
        dataForEdit || initVal
      }
      enableReinitialize
      validationSchema= {validate}
      onSubmit={values => {
        function first(){
          return new Promise(function(resolve, reject){
              console.log("First");
              // toBase64(myFile.file, (base64String)=>{
              // })
              resolve();
          });
      }
      
      function second(){
          return new Promise(function(resolve, reject){
              console.log("Second");
              setDataForAPI({
                typeEssai: {
                  id:values.typeEssai
              },
              institution: {
                  id:values.institution
              },
              position: {
                  id:42
              },
              fichier: {
                  id:1
              },
              motsCles: values.motsCles,
              pdf:dataForAPI.pdf
            })
            setDataForAPI((state) => {
              console.log(state); // "React is awesome!"
              
              return state;
            });
            
              resolve();
          });
      }
      
      function third(){
        // console.log(dataForAPI)
          return new Promise(function(resolve, reject){
              console.log("Third");
              const requestOptions = {
                method: match.params.id ?'PUT':'POST',
                headers: { 'Content-Type': 'application/json',
                'Accept': 'application/json'},
                body: JSON.stringify(dataForAPIref.current)
            };
            
            //check if it is POST or PUT
            if(match.params.id){
              fetch(`${process.env.REACT_APP_API_URL}/api/essais/`+match.params.id, requestOptions)
                .then(response => response.json())
                .then(data =>   setAlert({ ...alert,isActive: true, message: "Opération réussie !"}));
            }else{
              // console.log(requestOptions.body)
                fetch(`${process.env.REACT_APP_API_URL}/api/essais`, requestOptions)
                .then(response => response.json())
                // fetch(`${process.env.REACT_APP_API_URL}/api/essais`,
                //   {
                //     method: 'POST',
                //     body: values,
                //   }
                // )
                // .then(data =>   setAlert({ ...alert,isActive: true, message: "Opération réussie !"}))
                // .catch((error) => {
                //   console.error('Error:', error);
                // });
              }
              resolve();
          });
      }
      first()
      .then(second)
      .then(third);



          //console.log(values)
      //     function myfunction() {
      //       longfunctionfirst(shortfunctionsecond);
      //   }
      //   myfunction();

      //   function longfunctionfirst(callback) {
      //     toBase64(myFile.file, (base64String)=>{
      //       console.log('======1')
            
      //     setDataForAPI({
      //       typeEssai: {
      //         id:values.typeEssai
      //     },
      //     institution: {
      //         id:values.institution
      //     },
      //     position: {
      //         id:42
      //     },
      //     fichier: {
      //         id:1
      //     },
      //     motsCles: values.motsCles,
      //     // pdf:base64String
      //   })
      //   console.log(dataForAPI)
      //   callback();
      //   })
      // }
      //     //  toBase64(myFile.file)
      //     // .then((result) => {
      //     //   // console.log(result)
      //     //   setDataForAPI({
      //     //     typeEssai: {
      //     //       id:values.typeEssai
      //     //   },
      //     //   institution: {
      //     //       id:values.institution
      //     //   },
      //     //   position: {
      //     //       id:42
      //     //   },
      //     //   fichier: {
      //     //       id:1
      //     //   },
      //     //   motsCles: values.motsCles,
      //     //   //pdf:result
      //     // });
      //     // })
      //     // .then(res => {
      //     //   // console.log(dataForAPI)
      //     //   console.log(dataForAPI)
      //     // })
        
        
         
   
      // // values.pdf=getBase64(myFile.file);
      //   // Create an object of formData
      //   // const formData = new FormData();
      //   // formData.append('typeEssai', values.typeEssai);
      //   // formData.append('institution', values.institution);
      //   // formData.append('latitude', values.latitude);
      //   // formData.append('longitude', values.longitude);
      //   // formData.append('altitude', values.altitude);
      //   // formData.append('motsCles', values.motsCles);
      //   // formData.append('commentaire', values.commentaire);
      //   //.............
      // //   formData.append('file', myFile.file);
      // //   formData.append('essai', new Blob([JSON.stringify({
      // //     "typeEssai": Number(values.typeEssai),
      // //     "institution": values.institution,
      // //     "latitude": values.latitude,
      // //     "longitude": values.longitude,
      // //     "altitude": values.altitude,
      // //     "motsCles": values.motsCles,
      // //     "commentaire": values.commentaire
      // // })], {
      // //         type: "application/json"
      // //     }));
      // function shortfunctionsecond() {
      //   console.log('======2')
      //     const requestOptions = {
      //       method: match.params.id ?'PUT':'POST',
      //       headers: { 'Content-Type': 'application/json',
      //       'Accept': 'application/json'},
      //       body: JSON.stringify(dataForAPI)
      //   };
        
      //   //check if it is POST or PUT
      //   if(match.params.id){
      //     fetch(`${process.env.REACT_APP_API_URL}/api/essais/`+match.params.id, requestOptions)
      //       .then(response => response.json())
      //       .then(data =>   setAlert({ ...alert,isActive: true, message: "Opération réussie !"}));
      //   }else{
      //     // console.log(requestOptions.body)
      //       fetch(`${process.env.REACT_APP_API_URL}/api/essais`, requestOptions)
      //       .then(response => response.json())
      //       // fetch(`${process.env.REACT_APP_API_URL}/api/essais`,
      //       //   {
      //       //     method: 'POST',
      //       //     body: values,
      //       //   }
      //       // )
      //       // .then(data =>   setAlert({ ...alert,isActive: true, message: "Opération réussie !"}))
      //       // .catch((error) => {
      //       //   console.error('Error:', error);
      //       // });
      //     }
      //   }
     
            setTimeout(() => {
              setAlert({...alert, isActive: false, message:''})
            }, 4000)
      }}
    >
      { formik => (
        <div>
       <Form>
       { alert.isActive ?  <CAlert color="info" closeButton>{alert.message}</CAlert> : ''}
          <CRow>
            <CCol xs="12" sm="6">
              <CCard>
                  <CCardHeader>
                  Informations sur l'essai   {  match.params.id}
                 </CCardHeader>
                    <CCardBody>
                      <CFormGroup>
                          <TextField  label="Type d'essai*:" name="typeEssai" 
                          type="select" options={allTestTypes} placeholder="Entrer le type d'essai..."/>
                          <CFormText className="help-block">Veuillez entrer le type d'essai</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Institution*:" name="institution" 
                         type="select" options={allInstitutions} placeholder="Entrer l'institution" />
                        <CFormText className="help-block">Veuillez entrer l'institution</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Latitude*:" name="latitude" 
                        type="text" placeholder="Entrer la latitude" autoComplete="latitude"/>
                        <CFormText className="help-block">Veuillez entrer la latitude</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Longitude*:" name="longitude" 
                        type="text" placeholder="Entrer la longitude" autoComplete="longitude"/>
                        <CFormText className="help-block">Veuillez entrer la longitude</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Altitude*:" name="altitude" 
                        type="text" placeholder="Entrer l'altitude" autoComplete="altitude"/>
                        <CFormText className="help-block">Veuillez entrer l'altitude</CFormText>
                      </CFormGroup>
                    </CCardBody>
              </CCard>
            </CCol>
            <CCol xs="12" sm="6">
              <CCard>
                  <CCardHeader>
                  Informations sur l'essai   {  match.params.id}
                 </CCardHeader>
                    <CCardBody>  
                      <CFormGroup>
                        <TextField label="Mots clés:" name="motsCles" 
                        type="textarea" placeholder="Entrer les mots clés" autoComplete="motsCles"/>
                        <CFormText className="help-block">Veuillez entrer les mots clés</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Commentaires:" name="commentaire" 
                        type="textarea" placeholder="Entrer les commentaires" autoComplete="commentaire"/>
                        <CFormText className="help-block">Veuillez entrer un commentaire</CFormText>
                      </CFormGroup>
                      {/* <CFormGroup >
                        <TextField label="Fichier:" name="fichier" 
                        type="file" placeholder="Entrer le fichier" autoComplete="fichier"/>
                        <CFormText className="help-block">Veuillez entrer le fichier (Max: 2 MB)</CFormText>
                      </CFormGroup>  */}
                      <CFormGroup row>{}
                      <CCol xs="12" md="12">
                        <input  id="custom-file-input" 
                        // onChange={onFileChange}
                        type="file" 
                        accept="application/pdf, 
                        application/vnd.ms-excel"     
                        onChange={(event) => handleChange(event)}
                          />
                        <CLabel htmlFor="custom-file-input" variant="custom-file">
                           {myFile.file? myFile.file.name:'Choisir un fichier...'}
                        </CLabel>
                     
                      </CCol>
                    </CFormGroup>     
                    </CCardBody>
                    <CCardFooter>
                      <button className="btn btn-dark mt-3" type="submit">{match.params.id ? 'Modifier': 'Enregistrer'} </button>
                      <button className="btn btn-danger mt-3 ml-3" type='reset'>Réinitialiser</button>
                    </CCardFooter>
              </CCard>
            </CCol>
          </CRow>
       </Form>
        </div>    
      )
      }
    </Formik>   
  )
}
export default BasicForms
