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
     if( match.params.id ){
      fetch(`${process.env.REACT_APP_API_URL}/api/testtypes/`+match.params.id)
        .then((response) => response.json())
        .then((json) => setDataForEdit(json))
        
     }
    }, []);