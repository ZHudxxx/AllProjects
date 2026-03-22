// script.js



function showRoute(route) {
  if (route === 'learn') {
    document.querySelector('.tab[data-tab="notes"]').click();
    document.getElementById('questionText').textContent = 'Open a lesson and click Try a mini-practice to load related questions.';
  }
  if (route === 'quiz') {
    document.getElementById('questionText').textContent = 'Click Start Adventure to begin the quiz.';
  }
  if (route === 'home') {
    document.getElementById('questionText').textContent = 'Welcome home — continue your adventure.';
  }
}

document.querySelectorAll('.tab').forEach(t => t.addEventListener('click', () => {
  document.querySelectorAll('.tab').forEach(x => x.classList.remove('active'));
  t.classList.add('active');
  const tab = t.dataset.tab;
  document.getElementById('notesPanel').style.display = tab === 'notes' ? 'block' : 'none';
  document.getElementById('videoPanel').style.display = tab === 'video' ? 'block' : 'none';
  document.getElementById('examplesPanel').style.display = tab === 'examples' ? 'block' : 'none';
}));

const quizPool = [
  { q: 'What is x if x + 3 = 7?', choices: ['3', '4', '5', '2'], a: 1 },
  { q: 'Solve: 2x + 4 = 10. What is x?', choices: ['2', '3', '1', '4'], a: 1 },
  { q: 'If 3x = 12, x = ?', choices: ['4', '6', '3', '5'], a: 0 }
];
let current = null;
let score = 0;

function loadQuestion() {
  current = quizPool[Math.floor(Math.random() * quizPool.length)];
  document.getElementById('questionText').textContent = current.q;
  const choicesArea = document.getElementById('choicesArea');
  choicesArea.innerHTML = '';
  current.choices.forEach((c, i) => {
    const el = document.createElement('div');
    el.className = 'choice';
    el.textContent = c;
    el.addEventListener('click', () => choose(i, el));
    choicesArea.appendChild(el);
  });
  document.getElementById('nextQuestion').style.display = 'none';
}

function choose(i, el) {
  const choices = document.querySelectorAll('.choice');
  choices.forEach(c => c.style.pointerEvents = 'none');
  if (i === current.a) {
    el.classList.add('correct');
    score += 10;
    document.getElementById('quizScore').textContent = score;
    pushChat("Nice! That's correct. +10 XP");
  } else {
    el.classList.add('wrong');
    choices[current.a].classList.add('correct');
    pushChat('Not quite — check your algebra. Hint: isolate x by undoing operations');
  }
  document.getElementById('nextQuestion').style.display = 'inline-block';
}

document.getElementById('nextQuestion').addEventListener('click', () => loadQuestion());
document.getElementById('startAdventure').addEventListener('click', () => {
  loadQuestion();
  pushChat('Good luck on your mission! Ask me for hints anytime.');
});
document.getElementById('tryExercise').addEventListener('click', () => {
  loadQuestion();
  pushChat('Mini-practice loaded — try solving it!');
});

function openProfile() {
  document.getElementById('profileView').style.display = 'block';
}
function closeProfile() {
  document.getElementById('profileView').style.display = 'none';
}
document.getElementById('closeProfile').addEventListener('click', closeProfile);

const chatToggle = document.getElementById('chatToggle');
const chatWindow = document.getElementById('chatWindow');
const chatMessages = document.getElementById('chatMessages');
const chatInput = document.getElementById('chatInput');

chatToggle.addEventListener('click', () => {
  chatWindow.style.display = chatWindow.style.display === 'none' ? 'block' : 'none';
});
document.getElementById('sendChat').addEventListener('click', sendChat);
chatInput.addEventListener('keypress', e => {
  if (e.key === 'Enter') sendChat();
});

function pushChat(text, from = 'bot') {
  const div = document.createElement('div');
  div.className = 'bubble ' + (from === 'bot' ? 'bot' : 'user');
  div.innerHTML = text;
  chatMessages.appendChild(div);
  chatMessages.scrollTop = chatMessages.scrollHeight;
}

function sendChat() {
  const v = chatInput.value.trim();
  if (!v) return;
  pushChat(v, 'user');
  chatInput.value = '';
  setTimeout(() => handleBot(v), 350);
}

function handleBot(text) {
  const t = text.toLowerCase();
  if (t.startsWith('solve')) {
    const eq = text.slice(5).trim();
    const out = solveLinear(eq);
    if (out.ok) pushChat(`<strong>Solution:</strong> x = ${out.x}`);
    else pushChat('Sorry, I can currently solve simple linear equations in one variable like "2x+4=10".');
    return;
  }
  if (t.includes('hint')) {
    pushChat('Try to isolate x by performing inverse operations. For example, if 2x+4=10, subtract 4 then divide by 2.');
    return;
  }
  if (t.includes('help') || t.includes('how')) {
    pushChat('I can solve simple linear equations (type: solve 2x+4=10), give hints, and explain quiz mistakes.');
    return;
  }
  pushChat('I can solve simple linear equations if you type: solve 2x+4=10 — or ask for "hint" or "help".');
}

function solveLinear(eq) {
  if (!eq) return { ok: false };
  const s = eq.replace(/\s+/g, '');
  const m = s.match(/^([+-]?\d*)x([+-]\d+)?=([+-]?\d+)$/i);
  if (!m) return { ok: false };
  let a = m[1];
  if (a === '+' || a === '') a = '1';
  if (a === '-') a = '-1';
  a = Number(a);
  let b = m[2] ? Number(m[2]) : 0;
  const c = Number(m[3]);
  const x = (c - b) / a;
  if (!isFinite(x)) return { ok: false };
  return { ok: true, x: x };
}

setTimeout(() => pushChat('Hi! I am AlgebraBot — try: "solve 2x+4=10" or click Start Adventure.'), 600);