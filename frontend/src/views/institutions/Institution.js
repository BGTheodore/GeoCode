import React, { useState, useEffect } from 'react'
import { CCard, CCardBody, CCardHeader, CCol, CRow } from '@coreui/react'
import CIcon from '@coreui/icons-react'

const Institution = (props) => {
  return (
    <CRow>
      <CCol lg={6}>
        <CCard>
          <CCardHeader  className="text-muted">
           Identifiant de l'institution : {props.institution.id}
          </CCardHeader>
          <CCardBody>
            <ul>
              <li> Nom : {props.institution.name}</li>
              <li> Adresse : {props.institution.address}</li>
              <li> Téléphone 1 : {props.institution.phone1}</li>
              <li> Téléphone 2 : {props.institution.phone2}</li>
              <li><a>Email : {props.institution.email}</a></li>
              {/* mailto */}
              <li><a>Site web : {props.institution.webSite}</a></li>
              <li> Créé le : {props.institution.createdAt}</li>
              <li><a>Ajouté par : {props.institution.createdBy}</a></li>
              <li> Dernière modification : {props.institution.updatedAt}</li>
              <li><a>Modifié par : {props.institution.updatedBy}</a></li>
            </ul>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default Institution
