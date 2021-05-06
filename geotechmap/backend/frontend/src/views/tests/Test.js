import React from 'react'
import { CCard, CCardBody, CCardHeader, CCol, CRow } from '@coreui/react'

const Institution = (props) => {
  return (
    <CRow>
      <CCol lg={6}>
        <CCard>
          <CCardHeader  className="text-muted">
           Identifiant de l'eessai : {props.test.id}
          </CCardHeader>
          <CCardBody>
            <ul>
              <li>Nom : {props.test.name}</li>
              <li>Abbréviation : {props.test.abbreviation}</li>
              <li>Description : {props.test.description}</li>
              <li>Créé le : {props.test.createdDate}</li>
              <li>Créé par : <a href="#">{props.test.createdBy}</a></li>
              <li>Dernière modification : {props.test.lastModifiedDate}</li>
              <li>Modifié par: <a href="#">{props.test.lastModifiedBy}</a></li>
            </ul>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default Institution
