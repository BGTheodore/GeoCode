import React from "react";
import { CounterContextProvider } from "../EssaisContext";
import  CarteContent from './CarteContent';
  export default function Carte() {
  return (
  <CounterContextProvider>
    <CarteContent />
  </CounterContextProvider>
   
  )
}