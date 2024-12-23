import './style.css'
import typescriptLogo from './typescript.svg'
import viteLogo from '/vite.svg'
import { setupCounter } from './counter.ts'

document.querySelector<HTMLDivElement>('#app')!.innerHTML = `
  <div>
    <button id="btn"> <h1 style="color:red !important"> GET USERS </h1> </button>
    <ul id="users"></ul>
    <a href="https://vite.dev" target="_blank">
      <img src="${viteLogo}" class="logo" alt="Vite logo" />
    </a>
    <a href="https://www.typescriptlang.org/" target="_blank">
      <img src="${typescriptLogo}" class="logo vanilla" alt="TypeScript logo" />
    </a>
    <h1>Vite + TypeScript</h1>
    <div class="card">
      <button id="counter" type="button"></button>
    </div>
    <p class="read-the-docs">
      Click on the Vite and TypeScript logos to learn more
    </p>
  </div>
`

const btn = document.querySelector("#btn");
const users = document.querySelector("#users");

btn.addEventListener('click',e => {
    e.preventDefault();

    fetch("http://localhost:8084/api/users").then((res, rej) => {
        res.json().then(res => {
            users.innerHTML = [...res].map(user => {
                        return `${user.name} ${user.email}`
                    });
            });
    });
});



setupCounter(document.querySelector<HTMLButtonElement>('#counter')!)
