import React ,{useState, useEffect,useContext} from 'react';
import {Formik, Form} from 'formik';
import * as Yup from 'yup';
import {
  CButton,
  CCol,
  CContainer,
  CInputGroup,
  CInputGroupPrepend,
  CInputGroupAppend,
  CInputGroupText,
  CRow
} from '@coreui/react'
import CIcon from '@coreui/icons-react';
import { SearchTextField } from './SearchTextField';
import { CounterContext } from "./EssaisContext";


const Search = () => {

  const [searchContent, setSearchContent] = useState(null);
  const [essais, setEssais] = useContext(CounterContext);

  const initVal ={
    searchContent: ''
  }
  const validate = Yup.object({
    searchContent: Yup.string()
    .max(45,"Maximum 45 caractères")
    .required("Champs obligatire"),        
  })
  return (
    <Formik
    initialValues = {
      initVal
    }
    enableReinitialize
    validationSchema= {validate}
    onSubmit={values => {
    //  console.log(values)

    fetch(`${process.env.REACT_APP_API_URL}/api/essais/search?mot_cle=bonsoir`)
        .then((response) => response.json())
        .then((json) => setEssais(json)); 

    }}
  >
       { formik => (
        <div>
       <Form>
      <CContainer>
        <CRow className="justify-content-center">
          <CCol md="6">     
            <CInputGroup className="input-prepend">
              <CInputGroupPrepend>
                <CInputGroupText>
                  <CIcon name="cil-magnifying-glass" />
                </CInputGroupText>
              </CInputGroupPrepend>
              <SearchTextField name="searchContent" type="text" placeholder="Mots clés" />
              {/* <CInput size="16" name="searchContent" type="text" placeholder="Mots clés" /> */}
              <CInputGroupAppend>
              {/* <button className="btn btn-dark mt-3" type="submit">Rechercher</button> */}
                <CButton color="info" type="submit" >Rechercher</CButton>
              </CInputGroupAppend>
            </CInputGroup>
          </CCol>
        </CRow>
        <hr />
      </CContainer>
      </Form>  
      </div>    
      )
      }
      </Formik> 
     
  )
}

export default Search;
