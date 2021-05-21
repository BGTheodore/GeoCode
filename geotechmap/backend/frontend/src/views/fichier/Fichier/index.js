import React, { useContext } from "react";
import { CounterContext, CounterContextProvider } from "../EssaisContext";
import  Fichierontent from './FichierContent';
  export default function Fichier() {
  return (
  <CounterContextProvider>
      <CarteContent />
  </CounterContextProvider>
   
  )
}