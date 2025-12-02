// API de productos en español
const api = '/api/productos';

// Listar productos y renderizar tabla
async function listarProductos() {
  const res = await fetch(api);
  const productos = await res.json();
  const tbody = document.querySelector('#tablaProductos tbody');
  tbody.innerHTML = '';
  productos.forEach(p => {
    const tr = document.createElement('tr');
    tr.innerHTML = `<td>${p.id}</td><td>${p.name}</td><td>${p.price}</td><td>${p.stock}</td><td><button class=\"btn btn-sm btn-danger\" data-id=\"${p.id}\">Eliminar</button></td>`;
    tbody.appendChild(tr);
  });
}

// Eliminar producto
document.addEventListener('click', async (e) => {
  if (e.target.matches('button[data-id]')) {
    const id = e.target.getAttribute('data-id');
    await fetch(api + '/' + id, { method: 'DELETE' });
    listarProductos();
  }
});

// Crear producto con fetch
document.getElementById('crearBtn').addEventListener('click', async () => {
  const name = document.getElementById('nombre').value;
  const price = parseFloat(document.getElementById('precio').value || 0);
  const stock = parseInt(document.getElementById('stock').value || 0);
  const payload = { name, price, stock };
  const res = await fetch(api, { method: 'POST', headers: { 'Content-Type':'application/json' }, body: JSON.stringify(payload) });
  const text = await res.text();
  document.getElementById('mensajes').innerText = res.ok ? 'Creado OK' : 'Error: ' + text;
  listarProductos();
});

// Crear producto con axios
document.getElementById('axiosBtn').addEventListener('click', async () => {
  const name = document.getElementById('nombre').value + ' (axios)';
  const price = parseFloat(document.getElementById('precio').value || 0);
  const stock = parseInt(document.getElementById('stock').value || 0);
  try {
    await axios.post(api, { name, price, stock });
    document.getElementById('mensajes').innerText = 'Creado (axios)';
    listarProductos();
  } catch (err) {
    document.getElementById('mensajes').innerText = 'Error (axios): ' + (err.response ? err.response.data : err.message);
  }
});

listarProductos();
