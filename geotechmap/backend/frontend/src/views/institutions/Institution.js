import React from 'react'
import { CCard, CCardBody, CCardHeader, CCol, CRow } from '@coreui/react'

const Institution = (props) => {
  return (
    <CRow>
      <CCol lg={6}>
        <CCard>
          <CCardHeader  className="text-muted">
           Identifiant de l'institutions : {props.institution.id}
          </CCardHeader>
          <CCardBody>
            <ul>
              <li>Nom : {props.institution.name}</li>
              <li>Abbréviation : {props.institution.acronym}</li>
              <li>Site web : {props.institution.website}</li>
              <li>Email : {props.institution.email}</li>
              <li>Téléphone 1 : {props.institution.phone1}</li>
              <li>Téléphone 2 : {props.institution.phone2}</li>
              <li>Adresse: {props.institution.address}</li>
              <li>Numéro fiscal: {props.institution.taxNumber}</li>
              <li>Description : {props.institution.description}</li>
              <li>Créé le : {props.institution.createdDate}</li>
              <li>Créé par : <a href="#">{props.institution.createdBy}</a></li>
              <li>Dernière modification : {props.institution.lastModifiedDate}</li>
              <li>Modifié par: <a href="#">{props.institution.lastModifiedBy}</a></li>
            </ul>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default Institution
