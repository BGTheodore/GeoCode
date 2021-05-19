import React from 'react';
import { CSelect} from '@coreui/react';
import { ErrorMessage, useField } from 'formik';

export const TextField = ({label, type, options, ...props}) => {
    const [ field, meta] = useField(props);
    return (
        <div className="mb-2" >
            <label htmlFor={field.name}>{label}</label>
            {type == "textarea" ?
            <textarea 
            className={`form-control shadow-none ${meta.touched && meta.error && 'is-invalid' }`}
            placeholder="Veillez entrer la description..."
            rows="6"
            {...field} {...props}
            ></textarea>:
            type == "select" ?
            <CSelect custom name="select" id="select">
                 { options.map((option, key) => {              
                    return <option key={key} value="0">{option.nom}</option>
                    })}
                
            </CSelect>:
            <input 
            className={`form-control shadow-none ${meta.touched && meta.error && 'is-invalid' }`}
            {...field} {...props}
            />
            }
             <ErrorMessage component="div" name={field.name} style={{position: "absolute", color:"red", fontSize: ".6rem"} }/>
        </div>
    )
}