import React, { useState, useEffect } from 'react'
import { CCard, CCardBody, CCardHeader, CCol, CRow } from '@coreui/react'
import CIcon from '@coreui/icons-react'

const Institution = (props) => {
  return (
    <CRow>
      <CCol lg={6}>
        <CCard>
          <CCardHeader  className="text-muted">
           Identifiant du type d'essai : {props.testType.id}
          </CCardHeader>
          <CCardBody>
            <ul>
              <li> Nom : {props.testType.name}</li>
              <li> Abbréviation : {props.testType.abbreviation}</li>
              <li> Description : {props.testType.description}</li>
              <li> Créé le : {props.testType.createdAt}</li>
              <li><a>Ajouté par : {props.testType.createdBy}</a></li>
              <li> Dernière modification : {props.testType.updatedAt}</li>
              <li><a>Modifié par : {props.testType.updatedBy}</a></li>
            </ul>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default Institution
