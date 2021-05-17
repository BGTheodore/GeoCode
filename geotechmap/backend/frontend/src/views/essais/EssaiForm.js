import React ,{useState, useEffect} from 'react'
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
  CAlert
} from '@coreui/react'

const BasicForms = ({match}) => {

  useEffect(() => {
    //__START fetch all test types for the select field
      fetch(`${process.env.REACT_APP_API_URL}/api/testtypes/`)
        .then((response) => response.json())
        .then((json) => setAllTestTypes(json))
    //__END fetch all test types for the select field
   if( match.params.id ){
    fetch(`${process.env.REACT_APP_API_URL}/api/testtypes/`+match.params.id)
      .then((response) => response.json())
      .then((json) => setDataForEdit(json))   
   }
  }, []);

  const initVal ={
    name: '',
    abbreviation:'',
    description:'',
  }
  const [dataForEdit, setDataForEdit] = useState(null);
  const [allTestTypes, setAllTestTypes] = useState(null);
  const [alert, setAlert] = React.useState({ 
    isActive: false, status: '', message: '',})

  const validate = Yup.object({
    name: Yup.string()
      .max(45,"Maximum 45 caractères")
      .required("Champs obligatoire"),
    abbreviation: Yup.string()
    .max(45,"Maximum 45 caractères"),
    description: Yup.string()
      .max(255,"Maximum 255 caractères"),
        
  })
  
  return (
    <Formik
      initialValues = {
        dataForEdit || initVal
      }
      enableReinitialize
      validationSchema= {validate}
      onSubmit={values => {
       console.log(values)
          const requestOptions = {
            method: match.params.id ?'PUT':'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(values)
        };
        
        //check if it is POST or PUT
        if(match.params.id){
          fetch(`${process.env.REACT_APP_API_URL}/api/testtypes/`+match.params.id, requestOptions)
            .then(response => response.json())
            .then(data =>   setAlert({ ...alert,isActive: true, message: "Opération réussie !"}));
        }else{
            fetch(`${process.env.REACT_APP_API_URL}/api/testtypes/`, requestOptions)
            .then(response => response.json())
            .then(data =>   setAlert({ ...alert,isActive: true, message: "Opération réussie !"}));
          }

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
                          <TextField  label="Type d'essai*:" name="test_type" 
                          type="select" options={allTestTypes} placeholder="Entrer le nom du type d'essai..."
                           autoComplete="test_type"                       
                           />
                          <CFormText className="help-block">Veuillez entrer le nom du type d'essai</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Abbreviation*:" name="abbreviation" type="text" placeholder="Entrer l'abbréviation du type d'essai.." autoComplete="abbreviation"/>
                        <CFormText className="help-block">Veuillez entrer l'abbréviation du type d'essai</CFormText>
                      </CFormGroup>
                    </CCardBody>
              </CCard>
            </CCol>
            <CCol xs="12" sm="6">
              <CCard>
                  <CCardHeader>
                  Informations sur le type d'essai   {  match.params.id}
                 </CCardHeader>
                    <CCardBody>  
                      <CFormGroup>
                        <TextField label="Description:" name="description"  placeholder="Entrer la description de téléphone..." autoComplete="description"/>
                        <CFormText className="help-block">Veuillez entrer la description de l'essai</CFormText>
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
