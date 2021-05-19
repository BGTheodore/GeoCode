import React from 'react'
import { CCard, CCardBody, CCardHeader, CCol, CRow } from '@coreui/react'

const Fichier = (props) => {
    return (
      <CRow>
        <CCol lg={6}>
          <CCard>
            <CCardHeader  className="text-muted">
             Identifiant du fichier : {props.fichier.id}
            </CCardHeader>
            <CCardBody>
              <ul>
                <li>Lien : {props.fichier.lien}</li>
                <li>Format : {props.fichier.format}</li>
                <li>Capacité : {props.fichier.capacite}</li>
                <li>Créé le : {props.fichier.createdDate}</li>
                <li>Créé par : <a href="#">{props.fichier.createdBy}</a></li>
                <li>Dernière modification : {props.fichier.lastModifiedDate}</li>
                <li>Modifié par: <a href="#">{props.fichier.lastModifiedBy}</a></li>
              </ul>
            </CCardBody>
          </CCard>
        </CCol>
      </CRow>
    )
  }
  
  export default Fichier
  