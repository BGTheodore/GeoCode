import React ,{useState, useEffect} from 'react'
import {Formik, Form} from 'formik';
import { TextField } from './TextField';
import * as Yup from 'yup';
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
    fetch(`${process.env.REACT_APP_API_URL}/api/users/`+match.params.id)
      .then((response) => response.json())
      .then((json) => setInputValues(json))
   }
 
    
  }, []);

  const [inputValues, setInputValues] = useState({
    name: '', address: '', phone1: '', phone2: '', 
    email: '', webSite: '', taxNumber: '', description: '',
  });
  

  const [alert, setAlert] = React.useState({ 
    isActive: false, status: '', message: '',})
   const handleSubmit = (evt) => {
      evt.preventDefault();
      //VALIDATION
      const requestOptions = {
        method: match.params.id ?'PUT':'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(inputValues)
    };
    //check if it is POST or PUT
    if(match.params.id){
      fetch(`${process.env.REACT_APP_API_URL}/api/users/`+match.params.id, requestOptions)
        .then(response => response.json())
        .then(data =>   setAlert({ ...alert,isActive: true, message: "Opération réussie !"}));
    }else{
        fetch(`${process.env.REACT_APP_API_URL}/api/users/`, requestOptions)
        .then(response => response.json())
        .then(data =>   setAlert({ ...alert,isActive: true, message: "Opération réussie !"}));
      }

        setTimeout(() => {
          setAlert({...alert, isActive: false, message:''})
        }, 4000)
  }
   
  const validate = Yup.object({
    name: Yup.string()
      .max(45,"Maximum 45 caractères")
      .required("Champs obligatire"),
    address: Yup.string()
    .max(45,"Maximum 45 caractères")
    .required("Champs obligatire"),
    phone1: Yup.string()
      .max(15,"Maximum 15 caractères")
      .required("Champs obligatire"),
    phone2: Yup.string()
      .max(15,"Maximum 15 caractères")
      .required("Champs obligatire"),
    email: Yup.string()
      .email("Email invalide")
      .required("Champs obligatire"),
    webSite: Yup.string()
      .max(45,"Maximum 45 caractères")
      .required("Champs obligatire"),
    taxNumber: Yup.string()
      .max(45,"Maximum 45 caractères")
      .required("Champs obligatire"),
    description: Yup.string()
      .max(45,"Maximum 255 caractères")
      .required("Champs obligatire"),
        
  })
  return (
    <Formik
      initialValues = {{
        name: '',
        address: '',
        phone1: '',
        phone2: '',
        email: '',
        webSite:'',
        taxNumber:'',
        description:'',
      }}
      validationSchema= {validate}
      onSubmit={values => {
       console.log(values)
      }}
    >
      { formik => (
        <div>
       <Form>
          <CRow>
            <CCol xs="12" sm="6">
              <CCard>
                  <CCardHeader>
                  Informations sur l'institution   {  match.params.id}
                 </CCardHeader>
                    <CCardBody>
                      <CFormGroup>
                          <TextField label="Nom*:" name="name" type="text" placeholder="Entrer le nom de l'institution..." autoComplete="nom" />
                          <CFormText className="help-block">Veillez entrer le nom de l'institution</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Adresse*:" name="address" type="text" placeholder="Entrer l'adresse de l'institution.." autoComplete="address"/>
                        <CFormText className="help-block">Veillez entrer l'adresse de l'intitution</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Téléphone 1:" name="phone1" type="text" placeholder="Entrer un numéro de téléphone..." autoComplete="phone1"/>
                        <CFormText className="help-block">Veillez entrer un numéro de téléphone de l'institution</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Téléphone 2:" name="phone2" type="text" placeholder="Entrer un auntre numéro de téléphone..." autoComplete="phone2"/>
                        <CFormText className="help-block">Veillez entrer un autre numéro de téléphone de l'institution</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Email*:" name="phone2" type="text" placeholder="Enter l'email de l'institution..." autoComplete="email"/>
                        <CFormText className="help-block">Veillez entrer l'email de l'institution</CFormText>
                      </CFormGroup>
                    </CCardBody>
              </CCard>
            </CCol>
            <CCol xs="12" sm="6">
              <CCard>
                  <CCardHeader>
                  Informations sur l'institution   {  match.params.id}
                 </CCardHeader>
                    <CCardBody>
                      <CFormGroup>
                          <TextField label="Site web:" name="webSite" type="text" placeholder="Entrer le site web de l'institution..." autoComplete="webSite" />
                          <CFormText className="help-block">Veillez entrer le site web de l'institution</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Numéro social:" name="taxNumber" type="text" placeholder="Entrer le numéro social de l'institution.." autoComplete="taxNumber"/>
                        <CFormText className="help-block">Veillez entrer le numéro social de l'intitution</CFormText>
                      </CFormGroup>
                      <CFormGroup>
                        <TextField label="Description:" name="description" type="textarea" placeholder="Entrer la description de téléphone..." autoComplete="description"/>
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
