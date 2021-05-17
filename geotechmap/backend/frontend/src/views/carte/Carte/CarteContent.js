import React, { useContext } from "react";
import { Tooltip, Marker, Popup, TileLayer, MapContainer, LayersControl } from 'react-leaflet';
// import {Icon } from 'leaflet';
// import useSwr from 'swr';
import Search from '../Search';
import { CounterContext } from "../EssaisContext";
// const Carte = (props) => {
  export default function CarteContent() { 
    const [essais, setEssais] = useContext(CounterContext);
    //const [ activeCrime, setActiveCrime] = React.useState(null);
  //   const fetcher = (...args) => fetch(...args).then(response => response.json());
  //   const url = 
  //   "http://localhost:8080/api/essais"
  //   // "https://data.police.uk/api/crimes-street/all-crime?lat=52.6297296&lng=-1.1315927&date=2019-10"
  //  const { data, error } = useSwr(url, {fetcher });

  //  const essais = data && !error ? data.slice(0,100): [];

    const position = [51.505, -0.09]
  return (
  <div>
    <Search />
       <MapContainer style={{height:'70vh', width:'100%'}} center={[19.0558, -73.0513]} zoom={9} scrollWheelZoom={true}>
    <TileLayer
      attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
      url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
    />
      <LayersControl position="topright">
      <LayersControl.BaseLayer name="OpenStreetMap.BlackAndWhite">
        <TileLayer
          attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
          url="https://tiles.wmflabs.org/bw-mapnik/{z}/{x}/{y}.png"
        />
      </LayersControl.BaseLayer>
      <LayersControl.BaseLayer checked name="OpenTopoMap">
        <TileLayer
          attribution='Map data: &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, <a href="http://viewfinderpanoramas.org">SRTM</a> | Map style: &copy; <a href="https://opentopomap.org">OpenTopoMap</a> (<a href="https://creativecommons.org/licenses/by-sa/3.0/">CC-BY-SA</a>)'
          url="https://{s}.tile.opentopomap.org/{z}/{x}/{y}.png"
        />
      </LayersControl.BaseLayer>
      <LayersControl.BaseLayer checked name="OpenStreetMap.Mapnik">
        <TileLayer
          attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
      </LayersControl.BaseLayer>
   
    </LayersControl>



     {essais.map(essai => (
        < div key={essai.id} >
        <Marker
      
        position={[essai.position.latitude, 
        essai.position.longitude]}
        // onClick = {() => {
        //     alert('okoko')
        // }}
        >
             <Popup 
                position={[essai.position.latitude, essai.position.longitude]}
                >
            <div>
                    <h5><strong>Résultat de l'essai: {essai.id}</strong></h5>
                    <ul>
                        <li><strong>Nom du projet:</strong> ...</li>
                        <li><strong>Institution:</strong>{essai.institution.nom} ({essai.institution.sigle})</li>
                        <li><strong>Type d\'essai:</strong> {essai.typeEssai.nom}</li>
                        <li><strong>Latitude:</strong> {essai.position.latitude}</li>
                        <li><strong>Longitude:</strong> {essai.position.longitude}</li>
                        <li><strong>Altitude:</strong> {essai.position.altitude}</li>
                        <li><strong>Méthode:</strong> ...</li>
                        <li><strong>Résultat: </strong><a href={essai.fichier.lien}>Voir document</a></li>
                        <li><strong>Date de réalisation:</strong> {essai.createdDate}</li>
                    </ul>
            </div>
           </Popup>
           <Tooltip>Tooltip for Marker</Tooltip>
        </Marker>
               
       
    
     
        </div>
        
    )
    )} 
  </MapContainer>
  </div>
   
  )
}

// export default Carte
