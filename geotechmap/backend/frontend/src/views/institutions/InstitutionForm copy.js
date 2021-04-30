import React ,{useState, useEffect} from 'react'
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

  return (
    <>
          <form onSubmit={handleSubmit}>
            { alert.isActive ?  <CAlert color="info" closeButton>{alert.message}</CAlert> : ''}
         
      <CRow>
  
        <CCol xs="12" sm="6">
        <CCard>
            <CCardHeader>
              Informations sur l'institution   {  match.params.id}
            </CCardHeader>
            <CCardBody>
              <CForm >
                <CFormGroup>
                  <CLabel >Nom*</CLabel>
                  <CInput type="text" onChange={handleOnChange} value={inputValues.name} name="name" placeholder="Entrer le nom de l'institution.." autoComplete="nom"/>
                  <CFormText className="help-block">Veillez entrer le nom de l'institution</CFormText>
                </CFormGroup>
                <CFormGroup>
                  <CLabel >Adresse*</CLabel>
                  <CInput type="text" onChange={handleOnChange} value={inputValues.address} name="address" placeholder="Entrer l'adresse de l'institution.." autoComplete="address"/>
                  <CFormText className="help-block">Veillez entrer l'adresse de l'intitution</CFormText>
                </CFormGroup>
                <CFormGroup>
                  <CLabel >Téléphone 1</CLabel>
                  <CInput type="text" onChange={handleOnChange} value={inputValues.phone1} name="phone1" placeholder="Entrer un numéro de téléphone.." autoComplete="phone1"/>
                  <CFormText className="help-block">Veillez entrer un numéro de téléphone de l'institution</CFormText>
                </CFormGroup>
                <CFormGroup>
                  <CLabel >Téléphone 2</CLabel>
                  <CInput type="text" onChange={handleOnChange} value={inputValues.phone2} name="phone2" placeholder="Entrer un numéro de téléphone.." autoComplete="phone2"/>
                  <CFormText className="help-block">Veillez entrer un autre numéro de téléphone de l'institution</CFormText>
                </CFormGroup>
                <CFormGroup>
                  <CLabel >Email</CLabel>
                  <CInput type="email" onChange={handleOnChange} value={inputValues.email} name="email" placeholder="Enter l'email de l'institution.." autoComplete="email"/>
                  <CFormText className="help-block">Veillez entrer l'email de l'institution</CFormText>
                </CFormGroup>
              </CForm>
            </CCardBody>
          </CCard>
        </CCol>
        <CCol xs="12" sm="6">
          <CCard>
            <CCardHeader>
            Informations sur l'institution
            </CCardHeader>
            <CCardBody>
                <CFormGroup>
                  <CLabel >Site web</CLabel>
                  <CInput type="text" onChange={handleOnChange} value={inputValues.webSite} name="webSite" placeholder="Entrer le site web de l'institution.." autoComplete="webSite"/>
                  <CFormText className="help-block">Veillez entrer le site web de l'institution</CFormText>
                </CFormGroup>
                <CFormGroup>
                  <CLabel >Numéro social</CLabel>
                  <CInput type="text" onChange={handleOnChange} value={inputValues.taxNumber} name="taxNumber" placeholder="Entrer le numéro social de l'institution.." autoComplete="taxNumber"/>
                  <CFormText className="help-block">Veillez entrer le numéro social de l'institution</CFormText>
                </CFormGroup>
                <CFormGroup >
                    <CLabel htmlFor="textarea-input">Description</CLabel>
                    <CTextarea 
                      name="description" 
                      id="textarea-input" 
                      rows="9"
                      onChange={handleOnChange} value={inputValues.description}
                      placeholder="Veillez entrer la description de l'institution..." 
                    />
                </CFormGroup>
            </CCardBody>
            <CCardFooter>
              <CButton type="submit" size="sm" color="primary"><CIcon name="cil-scrubber" /> {match.params.id ? 'Modifier': 'Enregistrer'} </CButton>
              <CButton type="reset" size="sm" color="danger" onClick={() => onReinitialiserInput()}><CIcon name="cil-ban" /> Réinitialiser</CButton>
            </CCardFooter>
          </CCard>
        </CCol>
      
      </CRow>
      </form>
     </>
  )
}

export default BasicForms
