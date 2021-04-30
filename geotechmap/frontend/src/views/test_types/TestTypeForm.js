import React ,{useState, useEffect} from 'react'
import {Formik, Form} from 'formik';
import { TextField } from './TextField';
import * as Yup from 'yup';
import { ErrorMessage, useField } from 'formik';
import {
  CButton,
  CCard,
  CCardBody,
  CCardFooter,
  CCardHeader,
  CCol,
  CCollapse,
  CDropdownItem,
  CDropdownMenu,
  CDropdownToggle,
  CFade,
  CForm,
  CFormGroup,
  CFormText,
  CValidFeedback,
  CInvalidFeedback,
  CTextarea,
  CInput,
  CInputFile,
  CInputCheckbox,
  CInputRadio,
  CInputGroup,
  CInputGroupAppend,
  CInputGroupPrepend,
  CDropdown,
  CInputGroupText,
  CLabel,
  CSelect,
  CRow,
  CSwitch,
  CAlert
} from '@coreui/react'
import CIcon from '@coreui/icons-react'
import { DocsLink } from 'src/reusable'

const BasicForms = ({match}) => {
  //to know if the form is for create (return false) or for edit (return true)
  const [isEdit, setIsEdit] = React.useState(false);
  // const { id } = match.params;
  useEffect(() => {
   if( match.params.id ){
    fetch("http://localhost:8080/api/testtypes/"+match.params.id)
      .then((response) => response.json())
      .then((json) => setDataForEdit(json))
      
   }
 
    
  }, []);

  const [inputValues, setInputValues] = useState({
    name: '',
    abbreviation:'',
    description:'',
  });

  const initVal ={
    name: '',
    abbreviation:'',
    description:'',
  }
  const [dataForEdit, setDataForEdit] = useState(null);


  const [alert, setAlert] = React.useState({ 
    isActive: false, status: '', message: '',})

  const validate = Yup.object({
    name: Yup.string()
      .max(45,"Maximum 45 caractères")
      .required("Champs obligatire"),
    abbreviation: Yup.string()
    .max(45,"Maximum 45 caractères")
    .required("Champs obligatire"),
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
          fetch("http://localhost:8080/api/testtypes/"+match.params.id, requestOptions)
            .then(response => response.json())
            .then(data =>   setAlert({ ...alert,isActive: true, message: "Opération réussie !"}));
        }else{
            fetch("http://localhost:8080/api/testtypes/", requestOptions)
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
                  Informations sur le type de d'essai   {  match.params.id}
                 </CCardHeader>
                    <CCardBody>
                      <CFormGroup>
                          <TextField  label="Nom*:" name="name" 
                          type="text" placeholder="Entrer le nom du type d'essai..."
                           autoComplete="nom" 
                       
                           />
                         
                          <CFormText className="help-block">Veillez entrer le nom du type d'essai</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Abbreviation*:" name="abbreviation" type="text" placeholder="Entrer l'abbréviation du type d'essai.." autoComplete="abbreviation"/>
                        <CFormText className="help-block">Veillez entrer l'abbréviation du type d'essai</CFormText>
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
                        <CFormText className="help-block">Veillez entrer la description de l'institution</CFormText>
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
