import React from 'react'
import { CCard, CCardBody, CCardHeader, CCol, CRow } from '@coreui/react'

const TypeEssai = (props) => {
    return (
        <CRow>
          <CCol lg={6}>
            <CCard>
              <CCardHeader  className="text-muted">
               Identifiant du type d'essai : {props.typeEssai.id}
              </CCardHeader>
              <CCardBody>
                <ul>
                  <li>Nom : {props.typeEssai.nom}</li>
                  <li>Description : {props.typeEssai.description}</li>
                  <li>Créé le : {props.typeEssai.createdDate}</li>
                  <li>Créé par : <a href="#">{props.typeEssai.createdBy}</a></li>
                  <li>Dernière modification : {props.typeEssai.lastModifiedDate}</li>
                  <li>Modifié par: <a href="#">{props.typeEssai.lastModifiedBy}</a></li>
                </ul>
              </CCardBody>
            </CCard>
          </CCol>
        </CRow>
      )
    }
    
    export default TypeEssai