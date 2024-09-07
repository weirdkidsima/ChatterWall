document.addEventListener("DOMContentLoaded", function () {
    loadPosts();

    const postForm = document.getElementById('postForm');
    postForm.addEventListener('submit', function (event) {
        event.preventDefault();
        createPost();
    });

    const statsForm = document.getElementById('statsForm');
    if (statsForm) {
        statsForm.addEventListener('submit', function (event) {
            event.preventDefault();
            getStats();
        });
    }
});

function loadPosts() {
    fetch('/api/posts')
        .then(response => response.json())
        .then(data => {
            const postsElement = document.getElementById('posts');
            postsElement.innerHTML = '';
            data.forEach(post => {
                const li = document.createElement('li');
                li.innerHTML = `<strong class="${post.nickname === 'admin' ? 'admin-nickname' : ''}">${post.nickname}</strong>: ${post.content} <em>(${post.postTime})</em>`;
                postsElement.appendChild(li);
            });
        });
}

function createPost() {
    const nickname = document.getElementById('nickname').value;
    const content = document.getElementById('content').value;

    fetch('/api/posts', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'nickname': nickname,
            'content': content
        })
    })
        .then(response => response.json())
        .then(data => {
            loadPosts();
            document.getElementById('nickname').value = '';
            document.getElementById('content').value = '';
        });
}

function getStats() {
    const nickname = document.getElementById('nickname').value;
    fetch(`/api/stats/count/${nickname}`)
        .then(response => response.text())
        .then(data => {
            const statsResult = document.getElementById('statsResult');
            statsResult.innerHTML = `User ${nickname} has posted ${data} times.`;
        });
}
