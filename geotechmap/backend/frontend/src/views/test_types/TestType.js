import React from 'react'
import { CCard, CCardBody, CCardHeader, CCol, CRow } from '@coreui/react'

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
              <li>Nom : {props.testType.name}</li>
              <li>Abbréviation : {props.testType.abbreviation}</li>
              <li>Description : {props.testType.description}</li>
              <li>Créé le : {props.testType.createdDate}</li>
              <li>Créé par : <a href="#">{props.testType.createdBy}</a></li>
              <li>Dernière modification : {props.testType.lastModifiedDate}</li>
              <li>Modifié par: <a href="#">{props.testType.lastModifiedBy}</a></li>
            </ul>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default Institution
