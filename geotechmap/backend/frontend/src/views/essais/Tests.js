import React, { useState, useEffect } from 'react'
import {
  CCardBody,
  CDataTable,
  CButton,
  CCollapse,
} from '@coreui/react'
import Test from "./Essai";

  const Tests = () => {
  const [details, setDetails] = useState([])

  const toggleDetails = (index,id) => {
    const position = details.indexOf(index)
    let newDetails = details.slice()
    if (position !== -1) {
      newDetails.splice(position, 1)
    } else {
      newDetails = [...details, index]
    }

    setDetails(newDetails)
  }

  const fields = [
    { key: 'id', label:'ID', _style: { width: '2%'} },
    { key: 'typeEssai', labsigleel:'Type d\'esai', _style: { width: '20%'} },
    { key: 'sigle', label:'Sigle', _style: { width: '20%'} },
    { key: 'description', label:'Description', _style: { width: '20%'} },
    { key: 'createdDate', label:'Date de création', _style: { width: '10%'} },
    {
      key: 'show_details',
      label: 'Actions',
      _style: { width: '1%' },
      sorter: false,
      filter: false
    }
  ]

  const onDelete = (id) => {
    if (window.confirm("Confirmer la suppression")) {
      const requestOptions = {
        method: 'DELETE'
      };
      fetch(`${process.env.REACT_APP_API_URL}/api/essais/`+id, requestOptions)
        .then(response => console.log(response))
      const newList = data.filter((item) => item.id !== id);
      setData(newList);
    } else {
      
    }
  }

  
  const [data, setData] = useState([])
  useEffect(() => {
    fetch(`${process.env.REACT_APP_API_URL}/api/essais/`)
      .then((response) => response.json())
      .then((json) => setData(json)); 
    
  }, []);

  return (
    <div>
          <a href="/#/tests/create" >   
            <CButton variant="outline" color="success">Ajouter</CButton>
          </a>
            
          <CDataTable
      items={data}
      fields={fields}
      columnFilter
      tableFilter
      footer
      itemsPerPageSelect
      itemsPerPage={5}
      hover
      sorter
      pagination
      scopedSlots = {{
        'show_details':
          (item, index)=>{
            return (
              <td className="py-2">
                <CButton
                  color="primary"
                  variant="outline"
                  shape="square"
                  size="sm"
                  onClick={()=>{toggleDetails(index,item.id)}}
                >
                  {details.includes(index) ? 'Cacher' : 'Voir'}
                </CButton>                          
              </td>
              )
          },
          'typeEssai':
          (item)=>{
            return (
              <td> {item.typeEssai.nom} </td>
              )
          },
        'details':
            (item, index)=>{
              return (
              <CCollapse show={details.includes(index)}>
                <Test essai = {item} />
                <CCardBody>
                  <a href={`/#/tests/edit/${item.id}`}> 
                    <CButton size="sm" color="info">
                      Modifier
                    </CButton>
                  </a>
                  <CButton size="sm" color="danger" className="ml-1" onClick= {() =>{onDelete(item.id)}}>
                    Suprimmer
                  </CButton>
                </CCardBody>
              </CCollapse>
            )
          }
      }}
    />
    </div>
    
  )
    }
  export default Tests