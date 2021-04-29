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
  
  const handleOnChange = event => {
    const { name, value } = event.target;
    setInputValues({ ...inputValues, [name]: value });
  };
  const onReinitialiserInput = () =>{
    setInputValues({
      name: '', address: '', phone1: '', phone2: '', 
      email: '', webSite: '', taxNumber: '', description: '',
    })
  }

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
   const phoneRegExp = /^((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?$/

  // phoneNumber: Yup.string().matches(phoneRegExp, 'Phone number is not valid')
  const validate = Yup.object({
    name: Yup.string()
      .max(45,"Maximum 45 caractères")
      .required("Champs obligatire"),
    address: Yup.string()
    .max(45,"Maximum 45 caractères")
    .required("Champs obligatire"),
    phone1: Yup.string()
    .matches(phoneRegExp, 'Numéro invalide')
      .required("Champs obligatire"),
    phone2: Yup.string()
      .max(5,"Maximum 15 caractères")
      .required("Champs obligatire"),
    email: Yup.string()
      .email("Email invalide")
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
          </CRow>
        {/* <TextField label="name" name="name" type="text" />
        <TextField label="email" name="email" type="email" />
        <TextField label="phone" name="phone" type="text" /> */}
        
        <button className="btn btn-dark mt-3" type="submit">Save</button>
        <button className="btn btn-danger mt-3 ml-3" type='reset'>Reset</button>
       </Form>
        </div>
     
      )

      }

    </Formik>
   
  )
}

export default BasicForms
