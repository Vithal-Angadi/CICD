import pytest
from app import app

@pytest.fixture
def client():
    with app.test_client() as client:
        yield client

def test_print_ip(client):
    rv = client.get('/')
    assert rv.status_code == 200
    assert rv.data.decode('utf-8').strip().count('.') == 3  # Checking if response is a valid IP address

def test_health_check(client):
    rv = client.get('/health')
    assert rv.status_code == 200
    assert rv.json == {'success': True}

def test_print_name(client):
    rv = client.get('/name')
    assert rv.status_code == 200
    assert rv.data.decode('utf-8') == 'Harsha Jain'

if __name__ == '__main__':
    pytest.main()
